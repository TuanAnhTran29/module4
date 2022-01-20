package com.service;

import com.model.Category;
import com.model.Song;

import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService {
    static final List<Category> categories;
    static {
        categories= new ArrayList<>();
        categories.add(new Category(1,"R&B"));
        categories.add(new Category(2,"Tru tinh"));
        categories.add(new Category(3,"Do"));
        categories.add(new Category(4,"Rock"));
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void save(Category category) {
        categories.add(category);
    }

    @Override
    public Category findById(int id) {
        Category category= null;
        for (Category c: categories) {
            if (c.getId() == id){
                category=c;
                break;
            }
        }
        return category;
    }

    @Override
    public void update(int id, Category category) {
        for (Category s:categories) {
            if (s.getId() == id) {
                categories.set(categories.indexOf(s),category);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Category s: categories) {
            if (s.getId() == id){
                categories.remove(s);
            }
        }
    }
}
