package com.service.loancardservice;

import com.model.Book;
import com.model.LoanCard;

import java.util.List;
import java.util.Optional;

public interface ILoanCardService {
    Iterable<LoanCard> findAll();

    void update(LoanCard loanCard);

    Optional<LoanCard> findById(Long id);

    void create(LoanCard loanCard);

    void remove(Long id);

    Optional<LoanCard> findByCode(int code);

    List<Integer> findAllCode();
}
