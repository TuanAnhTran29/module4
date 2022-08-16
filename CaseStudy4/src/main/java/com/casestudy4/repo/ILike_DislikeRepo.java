package com.casestudy4.repo;

import com.casestudy4.model.Like_Dislike;
import com.casestudy4.model.Song;
import com.casestudy4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILike_DislikeRepo extends JpaRepository<Like_Dislike,Long> {
    Optional<Like_Dislike> findByUserAndSong(User user, Song song);
}
