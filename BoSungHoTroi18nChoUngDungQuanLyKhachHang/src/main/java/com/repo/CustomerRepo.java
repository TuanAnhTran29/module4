package com.repo;

import com.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long> {
}
