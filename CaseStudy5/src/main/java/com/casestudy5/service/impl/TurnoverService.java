package com.casestudy5.service.impl;

import com.casestudy5.model.Turnover;
import com.casestudy5.repo.ITurnoverRepo;
import com.casestudy5.service.ITurnoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurnoverService implements ITurnoverService {
    @Autowired
    private ITurnoverRepo turnoverRepo;

    @Override
    public Iterable<Turnover> findAll() {
        return turnoverRepo.findAll();
    }

    @Override
    public Optional<Turnover> findById(Long id) {
        return turnoverRepo.findById(id);
    }

    @Override
    public Turnover save(Turnover turnover) {
        return turnoverRepo.save(turnover);

    }

    @Override
    public void remove(Long id) {
        turnoverRepo.deleteById(id);
    }

    @Override
    public Optional<Turnover> findByUserId(Long id) {
        return turnoverRepo.findByUserId(id);
    }

    @Override
    public void save(Long uid, Turnover turnover) {
        Turnover turnover1= turnoverRepo.findByUserId(uid).get();

        if (turnover1 != null){
            turnover1.setRevenue(turnover1.getRevenue() + turnover.getRevenue());
        }else {
            turnover1= new Turnover();
            turnover1.setUser(turnover.getUser());
            turnover1.setRevenue(turnover.getRevenue());
        }

        turnoverRepo.save(turnover1);
    }


}
