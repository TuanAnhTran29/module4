package com.service;

import com.model.Customer;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    T save(T t);

    void remove(Long id);
}
