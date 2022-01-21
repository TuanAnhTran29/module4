package com.service;

import com.model.Song;
import com.model.SongForm;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    SongForm findByFormId(int id);

    void create(Song song);

    void remove(int id);
}
