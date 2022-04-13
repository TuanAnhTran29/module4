package com.casestudy5.service.impl;

import com.casestudy5.model.Product;
import com.casestudy5.repo.IProductRepo;
import com.casestudy5.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Optional<Product> findProductAndCategoryById(Long id) {
        return productRepo.findProductAndCategoryById(id);
    }

    @Override
    public Boolean existsByName(String name) {
        return productRepo.existsByName(name);
    }

    @Override
    public Iterable<Product> findAllProduct() {
        return productRepo.findAllProduct();
    }

    @Override
    public List<Product> findAllProductByName(String name) {
        return productRepo.findAllProductByName(name);
    }
}
