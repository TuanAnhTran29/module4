package com.model;


import javax.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String bookName;
    private int quantity;

    public Book(Long id, String author, String bookName, int quantity) {
        this.id = id;
        this.author = author;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public Book(String author, String bookName, int quantity) {
        this.author = author;
        this.bookName = bookName;
        this.quantity = quantity;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
