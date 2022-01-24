package com.repo;

import com.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CommentRepo implements ICommentRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        String sql= "select c from Comment c";
        TypedQuery<Comment> query= entityManager.createQuery(sql,Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        String sql= "select c from Comment c where c.id= :id";
        TypedQuery<Comment> query= entityManager.createQuery(sql,Comment.class).setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null){
            entityManager.merge(comment);
        }else {
            entityManager.persist(comment);
        }
    }

    @Override
    public void remove(Long id) {
        Comment comment= findById(id);
        if (comment != null){
            entityManager.remove(comment);
        }
    }
}
