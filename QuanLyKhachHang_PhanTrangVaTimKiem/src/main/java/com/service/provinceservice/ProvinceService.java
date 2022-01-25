package com.service.provinceservice;

import com.model.Province;
import com.repo.customerrepo.IProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepo provinceRepo;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepo.findAll();
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepo.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepo.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepo.deleteById(id);
    }
}
