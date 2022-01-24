package com.repo.customerrepo;

import com.model.Customer;
import com.repo.IGeneralRepo;

import javax.persistence.PersistenceContext;

public interface ICustomerRepo extends IGeneralRepo<Customer> {
}
