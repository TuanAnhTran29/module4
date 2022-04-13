package com.casestudy5.repo;

import com.casestudy5.model.Turnover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITurnoverRepo extends JpaRepository<Turnover,Long> {

    @Query(value = "select * from turnovers where user_id= ?1", nativeQuery = true)
    Optional<Turnover> findByUserId(Long id);

}
