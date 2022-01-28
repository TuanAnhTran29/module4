package com.controller;

import com.model.Cart;
import com.model.Product;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ShoppingCartController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/view-detail/{id}")
    public ModelAndView view(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("/view");
        Optional<Product> product= productService.findById(id);
        modelAndView.addObject("product",product);
        return modelAndView;

    }



}
