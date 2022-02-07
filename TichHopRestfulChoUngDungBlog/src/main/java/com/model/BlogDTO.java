package com.model;

public class BlogDTO {
    String summary;
    String content;

    public BlogDTO(String summary, String content) {
        this.summary = summary;
        this.content = content;
    }

    public BlogDTO() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
