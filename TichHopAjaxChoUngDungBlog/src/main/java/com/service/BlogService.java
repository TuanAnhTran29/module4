package com.service;

import com.model.Blog;
import com.repo.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepo.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogsByTitleLike(String title, Pageable pageable) {
        return blogRepo.findBlogsByTitleLike(title,pageable);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Iterable<Blog> findByCategoryId(Long id) {
        return blogRepo.findByCategoryId(id);
    }

    @Override
    public Iterable<Blog> findBlogLimit(Integer limit) {
        return blogRepo.getBlogLimit(limit);
    }
}
