package com.service;

import com.model.Song;
import com.model.SongForm;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {
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
    public List<Song> findAll() {
        String query= "select c from Song as c";
        TypedQuery<Song> query1= entityManager.createQuery(query,Song.class);
        return query1.getResultList();
    }

    @Override
    public void save(Song song) {
        Session session= null;
        Transaction transaction= null;
        try {
            session= sessionFactory.openSession();
            transaction= session.beginTransaction();
            Song song1= findById(song.getId());
            song1.setSongName(song.getSongName());
            song1.setArtist(song.getArtist());
            song1.setCategories(song.getCategories());
            song1.setPath(song.getPath());
            session.saveOrUpdate(song1);
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
    public Song findById(int id) {
        String query= "select c from Song as c where c.id = :id";
        TypedQuery<Song> query1= entityManager.createQuery(query,Song.class);
        query1.setParameter("id",id);
        return query1.getSingleResult();
    }

    @Override
    public SongForm findByFormId(int id) {
        String query= "select c from Song as c where c.id = :id";
        TypedQuery<SongForm> query1= entityManager.createQuery(query,SongForm.class);
        query1.setParameter("id",id);
        return query1.getSingleResult();
    }

    @Override
    public void create(Song song) {
        Session session= null;
        Transaction transaction= null;
        try {
            session= sessionFactory.openSession();
            transaction= session.beginTransaction();
            session.save(song);
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
    public void remove(int id) {
        Session session= null;
        Transaction transaction= null;
        try {
            session= sessionFactory.openSession();
            transaction= session.beginTransaction();
            Song song= findById(id);
            session.delete(song);
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
