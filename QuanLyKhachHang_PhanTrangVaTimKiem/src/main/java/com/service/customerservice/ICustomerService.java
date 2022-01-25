package com.service.customerservice;

import com.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Optional<Customer> findById(Long id);

    void save(Customer t);

    void remove(Long id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
