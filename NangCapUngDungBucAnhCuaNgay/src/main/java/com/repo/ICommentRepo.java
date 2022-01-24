package com.repo;

import com.model.Comment;

import java.util.List;

public interface ICommentRepo {
    List<Comment> findAll();

    Comment findById(Long id);

    void save(Comment comment);

    void remove(Long id);
}
