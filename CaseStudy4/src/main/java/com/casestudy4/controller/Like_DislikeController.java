package com.casestudy4.controller;

import com.casestudy4.dto.response.ResponseMessage;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/like_dislike")
public class Like_DislikeController {
    @Autowired
    private ILike_DislikeService like_dislikeService;

    @Autowired
    private ISongService songService;

    @Autowired
    private IUserService userService;



    @GetMapping("/dolike_dislike/{songId}/{userId}")
    public ResponseEntity<?> doLike(@PathVariable Long songId,@PathVariable Long userId){
        Optional<User> user= userService.findById(userId);
        Optional<Song> song= songService.findById(songId);
        Optional<Like_Dislike> like_dislike= like_dislikeService.findByUserAndSong(user.get(),song.get());
        if(!like_dislike.isPresent()){
            like_dislikeService.save(new Like_Dislike(user.get(),song.get(),0));
        }
        like_dislike= like_dislikeService.findByUserAndSong(user.get(),song.get());
        if(like_dislike.get().getLikes() == 0){
            like_dislike.get().setLikes(like_dislike.get().getLikes() + 1);
            like_dislikeService.save(like_dislike.get());
            return new ResponseEntity<>(new ResponseMessage("do like"), HttpStatus.OK);
        }else{
            like_dislike.get().setLikes(like_dislike.get().getLikes() - 1);
            like_dislikeService.save(like_dislike.get());
            return new ResponseEntity<>(new ResponseMessage("do dislike"), HttpStatus.OK);
        }
    }
}
