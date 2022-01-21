package com.controller;


import com.model.Category;
import com.model.Song;
import com.model.SongForm;
import com.service.CategoryService;
import com.service.ICategoryService;
import com.service.ISongService;
import com.service.SongService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("song")
@PropertySource("classpath:upload_song.properties")
public class SongController {
    @Value("${song-upload}")
    private String fileUpload;

    @Autowired
    private SongService songService;
    private ICategoryService categoryService= new CategoryService();

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("songs",songService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("song",new SongForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SongForm songForm){
        MultipartFile multipartFile= songForm.getPath();
        String fileName= multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song1= new Song(songForm.getSongName(),songForm.getArtist(),songForm.getCategories(),fileName);
        songService.create(song1);
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("song",songForm);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("update");
        Song song= songService.findById(id);
        SongForm songForm= new SongForm(song.getId(),song.getSongName(),song.getArtist(),song.getCategories());

        try {
            File file= new File(fileUpload + song.getPath());
            FileInputStream fileInputStream= new FileInputStream(file);

            MultipartFile multipartFile= new MockMultipartFile("file",song.getPath(),"audio", IOUtils.toByteArray(fileInputStream));
            songForm.setPath(multipartFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("songForm",songForm);
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SongForm songForm){
        MultipartFile multipartFile= songForm.getPath();
        String fileName= multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(songForm.getPath().getBytes(),new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song= new Song(songForm.getId(), songForm.getSongName(),songForm.getArtist(),songForm.getCategories(),fileName);
        System.out.println(song);
        songService.save(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("index");
        songService.remove(id);
        modelAndView.addObject("songs",songService.findAll());
        return modelAndView;
    }
}
