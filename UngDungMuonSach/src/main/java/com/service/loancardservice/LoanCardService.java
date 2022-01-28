package com.service.loancardservice;

import com.model.Book;
import com.model.LoanCard;
import com.repo.ILoanCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanCardService implements ILoanCardService {
    @Autowired
    private ILoanCardRepo loanCardRepo;

    @Override
    public Iterable<LoanCard> findAll() {
        return loanCardRepo.findAll();
    }

    @Override
    public void update(LoanCard loanCard) {
        loanCardRepo.save(loanCard);
    }

    @Override
    public Optional<LoanCard> findById(Long id) {
        return loanCardRepo.findById(id);
    }

    @Override
    public void create(LoanCard loanCard) {
        loanCardRepo.save(loanCard);
    }

    @Override
    public void remove(Long id) {
        loanCardRepo.deleteById(id);
    }

    @Override
    public Optional<LoanCard> findByCode(int code) {
        return loanCardRepo.findByCode(code);
    }

    @Override
    public List<Integer> findAllCode() {
        return loanCardRepo.findAllCode();
    }
}
