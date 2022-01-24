package com.service;

import com.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
