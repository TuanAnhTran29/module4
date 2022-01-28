package com.model;

import javax.persistence.*;

@Entity
@Table
public class LoanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;
    private int code;

    public LoanCard(Long id, int code,String bookName) {
        this.id = id;
        this.code = code;
        this.bookName= bookName;
    }

    public LoanCard(int code, String bookName) {
        this.code = code;
        this.bookName= bookName;
    }

    public LoanCard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
