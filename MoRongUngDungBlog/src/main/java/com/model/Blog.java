package com.model;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String summary;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Blog(Long id, String title, String content, String summary, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.category = category;
    }

    public Blog(String title, String content, String summary, Category category) {
        this.title = title;
        this.content = content;
        this.summary = summary;
        this.category = category;
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
