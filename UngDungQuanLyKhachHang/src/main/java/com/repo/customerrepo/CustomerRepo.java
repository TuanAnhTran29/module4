package com.repo.customerrepo;

import com.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepo implements ICustomerRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        try {
            TypedQuery<Customer> query= entityManager.createQuery("select c from Customer c",Customer.class);
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query= entityManager.createQuery("select c from Customer c where c.id= :id",Customer.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void save(Customer customer) {
        try {
            if (customer.getId() != null){
                entityManager.merge(customer);
            }else {
                entityManager.persist(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(Long id) {
        Customer customer= findById(id);
        if (customer != null){
            entityManager.remove(customer);
        }
    }
}
