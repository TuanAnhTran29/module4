package com.repo;

import com.model.Book;
import com.model.LoanCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILoanCardRepo extends CrudRepository<LoanCard, Long> {
    @Query(value = "from LoanCard where code = :code")
    Optional<LoanCard> findByCode(@Param("code") int code);

    @Query(value = "select code from loancard", nativeQuery = true)
    List<Integer> findAllCode();
}
