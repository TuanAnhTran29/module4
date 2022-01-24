package com.service;

import com.model.Blog;
import com.repo.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        System.out.println(id);
        blogRepo.remove(id);
    }
}
