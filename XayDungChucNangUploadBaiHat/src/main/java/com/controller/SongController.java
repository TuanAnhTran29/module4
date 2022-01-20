package com.controller;


import com.model.Song;
import com.model.SongForm;
import com.service.CategoryService;
import com.service.ICategoryService;
import com.service.ISongService;
import com.service.SongService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("song")
@PropertySource("classpath:upload_song.properties")
public class SongController {
    @Value("${song-upload}")
    private String fileUpload;

    private ISongService songService= new SongService();
    private ICategoryService categoryService= new CategoryService();

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("songs",songService.findAll());
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("song",new SongForm());
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute SongForm song){
        MultipartFile multipartFile= song.getPath();
        String fileName= multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(song.getPath().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song1= new Song(song.getId(),song.getSongName(),song.getArtist(),song.getCategories(),fileName);
        songService.save(song1);
        System.out.println(song1);
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("song",song);
        return modelAndView;
    }
}
