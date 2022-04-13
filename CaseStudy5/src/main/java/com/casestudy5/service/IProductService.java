package com.casestudy5.service;

import com.casestudy5.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGeneralService<Product>{
    Optional<Product> findProductAndCategoryById(Long id);

    Boolean existsByName(String name);

    Iterable<Product> findAllProduct();

    List<Product> findAllProductByName(String name);
}
