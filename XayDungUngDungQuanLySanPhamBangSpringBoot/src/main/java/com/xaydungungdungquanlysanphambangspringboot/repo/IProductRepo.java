package com.xaydungungdungquanlysanphambangspringboot.repo;

import com.xaydungungdungquanlysanphambangspringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product,Long> {
}
