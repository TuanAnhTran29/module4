package com.repo;

import com.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends PagingAndSortingRepository<Product,Long> {
}
