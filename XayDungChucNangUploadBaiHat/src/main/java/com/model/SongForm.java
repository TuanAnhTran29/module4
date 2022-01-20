package com.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class SongForm {
    private int id;
    private String songName;
    private String artist;
    private String categories;
    private MultipartFile path;

    public SongForm(int id, String songName, String artist, String categories, MultipartFile path) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.categories = categories;
        this.path = path;
    }

    public SongForm() {
    }

    public SongForm(String songName, String artist, String categories, MultipartFile path) {
        this.songName = songName;
        this.artist = artist;
        this.categories = categories;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
