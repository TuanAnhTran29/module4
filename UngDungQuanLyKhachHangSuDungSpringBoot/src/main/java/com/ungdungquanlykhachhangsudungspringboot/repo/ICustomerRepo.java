package com.ungdungquanlykhachhangsudungspringboot.repo;

import com.ungdungquanlykhachhangsudungspringboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Long> {

}
