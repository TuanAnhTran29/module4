package com.casestudy5.repo;

import com.casestudy5.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepo extends JpaRepository<Bill,Long> {

    @Query(value = "select * from bills where user_id= ?1", nativeQuery = true)
    Iterable<Bill> findAllByUserId(Long id);
}
