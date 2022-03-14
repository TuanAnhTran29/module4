package com.casestudy4.repo;

import com.casestudy4.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepo extends JpaRepository<Song,Long> {
    Iterable<Song> findByName(String name);

    Iterable<Song> findByArtist(String artist);

    @Query(value = "select * from songs where user_id= ?1", nativeQuery = true )
    Iterable<Song> findAllSongByUserId(Long id);

    @Query(value = "select songs.id,artist,lyrics,songs.name,path,picture,user_id from songs inner join song_category sc on songs.id = sc.song_id inner join categories c on sc.category_id = c.id where songs.name like %?1% or songs.artist like %?1% or c.name like %?1%", nativeQuery = true)
    Iterable<Song> searchSong( String name);
}
