package com.casestudy4.service.impl;

import com.casestudy4.model.Like_Dislike;
import com.casestudy4.model.Song;
import com.casestudy4.model.User;
import com.casestudy4.repo.ILike_DislikeRepo;
import com.casestudy4.service.ILike_DislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Like_DislikeService implements ILike_DislikeService {
    @Autowired
    private ILike_DislikeRepo like_dislikeRepo;
    @Override
    public Iterable<Like_Dislike> findAll() {
        return like_dislikeRepo.findAll();
    }

    @Override
    public Optional<Like_Dislike> findById(Long id) {
        return like_dislikeRepo.findById(id);
    }

    @Override
    public Like_Dislike save(Like_Dislike like_dislike) {
        return like_dislikeRepo.save(like_dislike);
    }

    @Override
    public void remove(Long id) {
        like_dislikeRepo.deleteById(id);
    }

    @Override
    public Optional<Like_Dislike> findByUserAndSong(User user, Song song) {
        return like_dislikeRepo.findByUserAndSong(user,song);
    }

    @Override
    public Iterable<Like_Dislike> findByUser(User user) {
        return like_dislikeRepo.findByUser(user);
    }
}
