package com.service;

import com.exception.BadFeedbackException;
import com.model.Comment;
import com.repo.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepo commentRepo;

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepo.findAll(pageable);
    }

    @Override
    public void update(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepo.findById(id);
    }

    @Override
    public void create(Comment comment) throws BadFeedbackException {
        try {
            commentRepo.save(comment);
        } catch (Exception e) {
            throw new BadFeedbackException();
        }

    }

    @Override
    public void remove(Long id) {
        commentRepo.deleteById(id);
    }
}
