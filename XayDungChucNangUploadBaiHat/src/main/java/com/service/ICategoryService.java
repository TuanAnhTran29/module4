package com.service;

import com.model.Category;
import com.model.Song;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void update(int id, Category category);

    void remove(int id);
}
