package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Service
public class HibernateCustomerServiceImpl implements CustomerService {
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
    public List<Customer> findAll() {
        String query= "select c from Customer as c";
        TypedQuery<Customer> query1= entityManager.createQuery(query,Customer.class);
        return query1.getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        String query= "select c from Customer as c where c.id = :id";
        TypedQuery<Customer> query1= entityManager.createQuery(query,Customer.class);
        query1.setParameter("id",id);
        return query1.getSingleResult();
    }

    @Override
    public Customer save(Customer customer) {
        Session session= null;
        Transaction transaction= null;
        try {
            session= sessionFactory.openSession();
            transaction= session.beginTransaction();
            Customer origin= findOne(customer.getId());
            origin.setName(customer.getName());
            origin.setEmail(customer.getEmail());
            origin.setAddress(customer.getAddress());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
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
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
