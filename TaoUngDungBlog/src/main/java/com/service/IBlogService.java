package com.service;

import com.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
