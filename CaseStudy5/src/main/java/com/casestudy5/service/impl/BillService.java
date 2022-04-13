package com.casestudy5.service.impl;

import com.casestudy5.model.Bill;
import com.casestudy5.repo.IBillRepo;
import com.casestudy5.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService implements IBillService {
    @Autowired
    private IBillRepo billRepo;

    @Override
    public Iterable<Bill> findAll() {
        return billRepo.findAll();
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return billRepo.findById(id);
    }

    @Override
    public Bill save(Bill bill) {
        return billRepo.save(bill);
    }

    @Override
    public void remove(Long id) {
        billRepo.deleteById(id);
    }

    @Override
    public Iterable<Bill> findAllByUserId(Long id) {
        return billRepo.findAllByUserId(id);
    }
}
