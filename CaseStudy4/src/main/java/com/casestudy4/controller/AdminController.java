package com.casestudy4.controller;

import com.casestudy4.model.Like_Dislike;
import com.casestudy4.model.Song;
import com.casestudy4.model.User;
import com.casestudy4.service.ILike_DislikeService;
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
    @Autowired
    private ILike_DislikeService like_dislikeService;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAllRoleUser(){
        return new ResponseEntity<>(userService.findAllRoleUser(), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        User user= userService.findById(userId).get();
        Iterable<Song> songs= songService.findAllSongByUserId(userId);
        for(Song s: songs){
            songService.remove(s.getId());
        }
        Iterable<Like_Dislike> like_dislikes= like_dislikeService.findByUser(user);
        for(Like_Dislike like_dislike: like_dislikes){
            like_dislikeService.remove(like_dislike.getId());
        }
        userService.remove(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username){
        return new ResponseEntity<>(userService.findUserByUsername(username),HttpStatus.OK);
    }
}
