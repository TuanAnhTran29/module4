package com.casestudy5.service.impl;

import com.casestudy5.model.Bill;
import com.casestudy5.model.Cart;
import com.casestudy5.model.Product;
import com.casestudy5.model.User;
import com.casestudy5.repo.ICartRepo;
import com.casestudy5.service.IBillService;
import com.casestudy5.service.ICartSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.*;

@Service
@SessionAttributes("cart")
public class CartService implements ICartSerivce {

    @Autowired
    private ICartRepo cartRepo;

    @Autowired
    private IBillService billService;

    @ModelAttribute("cart")
    Cart setUpCart(){
        return new Cart();
    }

    @Override
    public Iterable<Cart> findAll() {
        return cartRepo.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepo.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public void remove(Long id) {
        cartRepo.deleteById(id);
    }

    @Override
    public void addToCart(Product product, int quantity, User user) {
        int addedQuantity= quantity;

        Cart cart= cartRepo.findByUserAndProduct(user,product);

        if (cart != null){
            addedQuantity = cart.getQuantity() + quantity;
            cart.setQuantity(addedQuantity);

        }else {
            cart = new Cart(product,user,addedQuantity);
        }

        cartRepo.save(cart);
    }

    @Override
    public List<Cart> findByUser(User user) {
        return cartRepo.findByUser(user);
    }

    @Override
    public void updateCart(int quantity, Long id) {
        cartRepo.updateCart(quantity,id);
    }

    @Override
    public void deleteCartByProductId(Long id) {
        cartRepo.deleteCartByProductId(id);
    }
}
