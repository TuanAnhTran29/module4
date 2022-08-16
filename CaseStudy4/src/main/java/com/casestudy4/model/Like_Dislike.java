package com.casestudy4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "like_dislike")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like_Dislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY,targetEntity = Song.class)
    @JoinColumn(name = "song_id")
    private Song song;

    private int likes;

    public Like_Dislike(User user, Song song, int likes) {
        this.user = user;
        this.song = song;
        this.likes = likes;
    }
}
