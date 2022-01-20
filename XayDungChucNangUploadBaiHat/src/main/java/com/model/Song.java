package com.model;

import java.util.List;

public class Song {
    private int id;
    private String songName;
    private String artist;
    private String categories;
    private String path;

    public Song(String songName, String artist, String categories, String path) {
        this.songName = songName;
        this.artist = artist;
        this.categories = categories;
        this.path = path;
    }
    public Song() {
    }

    public Song(int id, String songName, String artist, String categories, String path) {
        this.id = id;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", artist='" + artist + '\'' +
                ", categories=" + categories +
                ", path='" + path + '\'' +
                '}';
    }
}
