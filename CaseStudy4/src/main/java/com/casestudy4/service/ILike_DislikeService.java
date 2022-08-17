package com.casestudy4.service;

import com.casestudy4.model.Like_Dislike;
import com.casestudy4.model.Song;
import com.casestudy4.model.User;

import java.util.Optional;

public interface ILike_DislikeService extends IGeneralService<Like_Dislike> {

    Optional<Like_Dislike> findByUserAndSong(User user,Song song);

    Iterable<Like_Dislike> findByUser(User user);
}
