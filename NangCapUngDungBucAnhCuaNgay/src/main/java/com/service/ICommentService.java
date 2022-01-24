package com.service;

import com.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    void update(Comment comment);

    Comment findById(Long id);

    void create(Comment comment);

    void remove(Long id);
}
