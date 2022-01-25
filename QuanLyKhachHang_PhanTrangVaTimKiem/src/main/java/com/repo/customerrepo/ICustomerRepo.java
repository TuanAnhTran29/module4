package com.repo.customerrepo;

import com.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByFirstNameContraining(String firstName, Pageable pageable);
}
