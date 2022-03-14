package com.casestudy4.service.impl;

import com.casestudy4.model.Song;
import com.casestudy4.repo.ISongRepo;
import com.casestudy4.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepo songRepo;


    @Override
    public Iterable<Song> findByName(String name) {
        return songRepo.findByName(name);
    }

    @Override
    public Iterable<Song> findByArtist(String artist) {
        return songRepo.findByArtist(artist);
    }

    @Override
    public Iterable<Song> findAllSongByUserId(Long id) {
        return songRepo.findAllSongByUserId(id);
    }

    @Override
    public Iterable<Song> searchSong(String search) {
        return songRepo.searchSong(search);
    }

    @Override
    public Iterable<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepo.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songRepo.save(song);
    }

    @Override
    public void remove(Long id) {
        songRepo.deleteById(id);
    }
}
