package com.casestudy4.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Lob
    private String picture;

    @NotBlank
    @Size(min = 4, max = 100)
    private String artist;

    @NotBlank
    @Size(min = 1)
    private String lyrics;

    private String path;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Category.class)
    @JoinTable(name = "song_category", joinColumns = @JoinColumn(name = "songId"), inverseJoinColumns = @JoinColumn(name = "categoryId") )
    Set<Category> categories= new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Song(Long id, String name, String picture, String artist, String lyrics, Set<Category> categories, String path, User user) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.artist = artist;
        this.lyrics = lyrics;
        this.categories = categories;
        this.path= path;
        this.user= user;
    }

    public Song(Long id, String name, String picture, String artist, String lyrics, String path, User user) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.artist = artist;
        this.lyrics = lyrics;
        this.path = path;
        this.user= user;
    }

    public Song(String name, String picture, String artist, String lyrics, String path, Set<Category> categories, User user) {
        this.name = name;
        this.picture = picture;
        this.artist = artist;
        this.lyrics = lyrics;
        this.path = path;
        this.categories = categories;
        this.user= user;
    }
}
