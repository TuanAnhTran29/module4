package com.repo;

import com.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepo implements IBlogRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        String sql= "select b from Blog b";
        TypedQuery<Blog> query= entityManager.createQuery(sql,Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        String sql= "select b from Blog b where b.id= :id";
        TypedQuery<Blog> query= entityManager.createQuery(sql,Blog.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() !=  null){
            entityManager.merge(blog);
        }else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void remove(Long id) {
        Blog blog= findById(id);
        if (blog != null){
            entityManager.remove(blog);
        }
    }
}
