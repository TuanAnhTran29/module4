package com.service.customerservice;

import com.model.Customer;
import com.repo.customerrepo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.remove(id);
    }
}
