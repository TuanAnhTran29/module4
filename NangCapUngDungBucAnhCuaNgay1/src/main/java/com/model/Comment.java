package com.model;


import javax.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int likes=0;
    private String author;
    private String feedBack;
    private int rate;

    public Comment(Long id, int likes, String author, String feedBack,int rate) {
        this.id = id;
        this.likes = likes;
        this.author = author;
        this.feedBack = feedBack;
        this.rate= rate;
    }

    public Comment(int likes, String author, String feedBack,int rate) {
        this.likes = likes;
        this.author = author;
        this.feedBack = feedBack;
        this.rate= rate;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLike() {
        return likes;
    }

    public void setLike(int likes) {
        this.likes = likes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
