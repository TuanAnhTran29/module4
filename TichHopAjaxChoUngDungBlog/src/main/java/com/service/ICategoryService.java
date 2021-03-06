package com.service;

import com.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
}
