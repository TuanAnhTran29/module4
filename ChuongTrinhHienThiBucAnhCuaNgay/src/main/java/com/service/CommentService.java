package com.service;

import com.model.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Service
public class CommentService implements ICommentService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory= new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager= sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Comment> findAll() {
        String query= "select c from Comment as c";
        TypedQuery<Comment> query1= entityManager.createQuery(query,Comment.class);
        return query1.getResultList();
    }

    @Override
    public void create(Comment comment) {
        Session session= null;
        Transaction transaction= null;
        try {
            session= sessionFactory.openSession();
            transaction= session.beginTransaction();
            session.save(comment);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }



    @Override
    public Comment findById(Long id) {
        String queryStr= "select c from Comment as c where id= :id";
        TypedQuery<Comment> query=entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void update(Comment comment) {
        Session session= null;
        Transaction transaction= null;
        try {
            session= sessionFactory.openSession();
            transaction= session.beginTransaction();
            Comment comment1= findById(comment.getId());
            comment1.setLike(comment.getLike());
            comment1.setAuthor(comment.getAuthor());
            comment1.setFeedBack(comment.getFeedBack());
            session.saveOrUpdate(comment1);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void remove(Long id) {
        Session session= null;
        Transaction transaction= null;
        try {
            session= sessionFactory.openSession();
            transaction= session.beginTransaction();
            Comment comment= findById(id);
            session.delete(comment);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
}
