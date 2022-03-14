package com.casestudy4.controller;

import com.casestudy4.model.Song;
import com.casestudy4.model.User;
import com.casestudy4.service.ISongService;
import com.casestudy4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ISongService songService;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllRoleUser(){
        return new ResponseEntity<>(userService.findAllRoleUser(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        Iterable<Song> songs= songService.findAllSongByUserId(userId);
        for (Song s: songs) {
            songService.remove(s.getId());
        }
        userService.remove(userId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
