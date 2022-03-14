package com.casestudy4.service;

import com.casestudy4.model.Song;

import java.util.Optional;

public interface ISongService extends IGeneralService<Song> {

    Iterable<Song> findByName(String name);

    Iterable<Song> findByArtist(String artist);

    Iterable<Song> findAllSongByUserId(Long id);

    Iterable<Song> searchSong(String search);
}
