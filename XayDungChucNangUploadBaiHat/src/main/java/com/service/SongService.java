package com.service;

import com.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService implements ISongService {
    List<Song> songs= new ArrayList<>();

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public void save(Song song) {
        songs.add(song);
    }

    @Override
    public Song findById(int id) {
        Song song= null;
        for (Song s: songs) {
            if (s.getId() == id){
                song=s;
                break;
            }
        }
        return song;
    }

    @Override
    public void update(int id, Song song) {
        for (Song s:songs) {
            if (s.getId() == id) {
                songs.set(songs.indexOf(s),song);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Song s: songs) {
            if (s.getId() == id){
                songs.remove(s);
            }
        }
    }
}
