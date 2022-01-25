package com.service.provinceservice;

import com.model.Province;

import java.util.Optional;

public interface IProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province t);

    void remove(Long id);
}
