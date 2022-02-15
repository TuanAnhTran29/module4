package com.xaydungungdungquanlysanphambangspringboot.controller;

import com.xaydungungdungquanlysanphambangspringboot.model.Product;
import com.xaydungungdungquanlysanphambangspringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView listProduct(){
        ModelAndView modelAndView= new ModelAndView("/list");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-product")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("/create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/create-product")
    public ModelAndView createProduct(@ModelAttribute Product product){
        productService.save(product);
        ModelAndView modelAndView= new ModelAndView("/create");
        modelAndView.addObject("message","Create product successfully");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @GetMapping("/edit-product/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id){
        Optional<Product> product= productService.findById(id);
        if (product.isPresent()){
            ModelAndView modelAndView= new ModelAndView("/edit");
            modelAndView.addObject("product",product.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/edit-product")
    public ModelAndView updateProduct(@ModelAttribute Product product){
        ModelAndView modelAndView= new ModelAndView("/edit");
        productService.save(product);
        modelAndView.addObject("message","Update product successfully");
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @GetMapping("/delete-product{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Product> product= productService.findById(id);
        if (product.isPresent()){
            ModelAndView modelAndView= new ModelAndView("/delete");
            modelAndView.addObject("product",product.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/delete-product")
    public ModelAndView deleteProduct(@ModelAttribute Product product){
        ModelAndView modelAndView= new ModelAndView("/list");
        productService.remove(product.getId());
        return modelAndView;
    }



}
