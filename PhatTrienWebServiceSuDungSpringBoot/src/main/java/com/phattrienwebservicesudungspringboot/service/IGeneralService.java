package com.phattrienwebservicesudungspringboot.service;

import com.phattrienwebservicesudungspringboot.model.Weather;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<Weather> findAll();

    Optional<Weather> findById(Long id);

    void save(Weather weather);

    void remove(Long id);
}
