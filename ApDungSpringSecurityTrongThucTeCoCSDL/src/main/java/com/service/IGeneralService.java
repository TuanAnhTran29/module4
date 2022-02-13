package com.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    void save(T t);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}
