package com.service;

import com.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    Page<Comment> findAll(Pageable pageable);

    void update(Comment comment);

    Optional<Comment> findById(Long id);

    void create(Comment comment);

    void remove(Long id);
}
