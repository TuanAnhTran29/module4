package com.service.customerservice;

import com.model.Customer;
import com.repo.customerrepo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return customerRepo.findAllByFirstNameContraining(firstName,pageable);
    }
}
