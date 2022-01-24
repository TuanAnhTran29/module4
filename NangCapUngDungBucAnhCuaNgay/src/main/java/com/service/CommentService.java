package com.service;

import com.model.Comment;
import com.repo.ICommentRepo;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepo commentRepo;

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public void create(Comment comment) {
        commentRepo.save(comment);
    }



    @Override
    public Comment findById(Long id) {
        return commentRepo.findById(id);
    }

    @Override
    public void update(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepo.remove(id);
    }
}
