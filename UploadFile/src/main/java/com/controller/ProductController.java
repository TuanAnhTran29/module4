package com.controller;

import com.model.Product;
import com.model.ProductForm;
import com.service.IProductService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;


    private final IProductService productService= new ProductService();

    @GetMapping
    public String index(Model model){
        List<Product> products= productService.findAll();
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("productForm",new ProductForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm){
        MultipartFile file= productForm.getImage();
        String fileName= file.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product= new Product(productForm.getId(), productForm.getName(),productForm.getDescription(),fileName);
        productService.save(product);
        System.out.println(fileUpload + product.getImage());
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("productForm",productForm);
        modelAndView.addObject("message","Created new product successfully !");
        return modelAndView;
    }
}
