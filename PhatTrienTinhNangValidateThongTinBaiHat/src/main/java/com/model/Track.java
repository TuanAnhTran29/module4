package com.model;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
public class Track implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 1,max = 800)
    private String name;

    @NotEmpty
    @Size(min = 1, max = 300)
    private String artist;

    @NotEmpty
    @Size(min = 1, max = 1000)
    private String category;

    public Track(Long id,@NotEmpty
    @Size(min = 1,max = 800) String name,@NotEmpty
    @Size(min = 1, max = 300) String artist,@NotEmpty
    @Size(min = 1, max = 1000) String category) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
    }

    public Track(@NotEmpty
                 @Size(min = 1,max = 800) String name, @NotEmpty
    @Size(min = 1, max = 300) String artist, @NotEmpty
    @Size(min = 1, max = 1000) String category) {
        this.name = name;
        this.artist = artist;
        this.category = category;
    }

    public Track() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Track.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Track track= (Track) target;
        String name= track.getName();
        String artist= track.getArtist();
        String category= track.getCategory();
        if (!name.matches("^[A-Za-z0-9]+$") ){
            errors.rejectValue("name","special-characters");
        }
        if (!artist.matches("^[A-Za-z0-9]+$")) {
            errors.rejectValue("artist","special-characters");
        }
        if (!category.matches("^[A-Za-z0-9]+$")){
            errors.rejectValue("category","only-comma");
        }
    }
}
