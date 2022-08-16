package com.casestudy4.controller;

import com.casestudy4.dto.response.ResponseMessage;
import com.casestudy4.model.Song;
import com.casestudy4.model.User;
import com.casestudy4.service.ISongService;
import com.casestudy4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/song")
@PropertySource("classpath:song-upload.properties")
public class SongController {
    @Autowired
    private ISongService songService;

    @Autowired
    private IUserService userService;

    @Value("${song-upload}")
    private String songUpload;

    @GetMapping
    public ResponseEntity<Iterable<Song>> listSong(){
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Long id){
        return new ResponseEntity<>(songService.findById(id).get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody Song song){
        for(Song s : songService.findAll()){
            if(s.getName().equals(song.getName()) && s.getArtist().equals(song.getArtist()) && s.getLyrics().equals(song.getLyrics())){
                return new ResponseEntity<>(new ResponseMessage("You already have this song!"), HttpStatus.OK);
            }
        }
        songService.save(song);
        return new ResponseEntity<>(new ResponseMessage("Created Song Successfully!"), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateSong(@RequestBody Song song ,@PathVariable Long id){
        Optional<Song> songOptional= songService.findById(id);
        if (!songOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            song.setId(songOptional.get().getId());
            songService.save(song);
            return new ResponseEntity<>(new ResponseMessage("Updated Song Successfully!"), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id){
//        Optional<Song> songOptional= songService.findById(id);
//        if (songOptional.isPresent()){
//            songService.remove(songOptional.get().getId());
//            return new ResponseEntity<>("Deleted song successfully!", HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
        songService.remove(id);
        return new ResponseEntity<>("Deleted song successfully!", HttpStatus.OK);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findAllSongByUserId(@PathVariable Long userId){
//        Optional<User> userOptional= userService.findById(userId);
//        if (userOptional.isPresent()){
//            return new ResponseEntity<>(songService.findAllSongByUserId(userOptional.get().getId()),HttpStatus.FOUND);
//        }else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(songService.findAllSongByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchSong(@PathVariable String keyword){
        System.out.println(keyword);
        return new ResponseEntity<>(songService.searchSong(keyword),HttpStatus.OK);
    }

}
