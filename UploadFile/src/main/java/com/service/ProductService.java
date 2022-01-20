package com.service;

import com.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    List<Product> products= new ArrayList<>();
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        for (Product p: products) {
            if (p.getId() == id){
                product= p;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Product p: products) {
            if (p.getId() == id){
                products.remove(p);
                break;
            }
        }
    }
}
