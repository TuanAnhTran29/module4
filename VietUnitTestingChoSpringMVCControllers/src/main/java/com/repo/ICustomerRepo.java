package com.repo;

import com.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();

    Customer add(Customer customer);

    Customer findById(int id);
}
