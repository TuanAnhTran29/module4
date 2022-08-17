package com.casestudy5.service;

import com.casestudy5.model.Cart;
import com.casestudy5.model.Product;
import com.casestudy5.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface ICartSerivce extends IGeneralService<Cart> {

    void addToCart(Product product , int quantity, User user);

    List<Cart> findByUser(User user);

    void updateCart(int quantity, Long id);

    void deleteCartByProductId(Long id);
}
