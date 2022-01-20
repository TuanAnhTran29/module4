package com.controller;


import com.model.Product;
import com.service.IProductService;
import com.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    private final IProductService productService= new ProductService();

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index");
        List<Product> products= productService.findAll();
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("product",new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) Math.random() * 10000);
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("edit");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(),product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("delete");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success","Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("view");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
}
