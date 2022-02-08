package com.service;

import com.model.SmartPhone;
import com.repo.ISmartPhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {
    @Autowired
    private ISmartPhoneRepo smartPhoneRepo;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepo.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepo.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepo.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepo.deleteById(id);
    }
}
