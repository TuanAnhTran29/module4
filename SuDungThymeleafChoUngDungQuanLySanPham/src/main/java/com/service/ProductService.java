package com.service;

import com.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final List<Product> productList;

    static {
        productList= new ArrayList<>();
        productList.add(new Product("Gao",12000,"GAO","TuanAnh"));
        productList.add(new Product("Nuoc",5000,"NUOC","TuanAnhTran"));
        productList.add(new Product("Sua",1000000,"SUA","Tuan"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        Product product= productList.get(id);
        return product;
    }

    @Override
    public Product findByName(String name) {
        Product product= null;
        for (Product p: productList) {
            if (p.getName().equals(name)){
                product= p;
                break;
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        int index= 0;
        for (Product p: productList) {
            if (p.getId()==id){
                productList.set(index,product);
            }
            index++;
        }
    }

    @Override
    public void remove(int id) {
        Product product= null;
        for (Product p: productList){
            if (p.getId() == id) {
                product= p;
                productList.remove(product);
                break;
            }
        }
    }
}
