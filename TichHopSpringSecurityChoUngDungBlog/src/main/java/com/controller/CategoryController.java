package com.controller;

import com.model.Category;
import com.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("create-category")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }

    @PostMapping("create-category")
    public ModelAndView saveCategory(@ModelAttribute Category category){
        ModelAndView modelAndView= new ModelAndView("category/create");
        categoryService.save(category);
        modelAndView.addObject("category",new Category());
        modelAndView.addObject("message","Added category successfully");
        return modelAndView;
    }

    @GetMapping("list-category")
    public ModelAndView listCategory(){
        ModelAndView modelAndView= new ModelAndView("blog/list");
        Iterable<Category> categories= categoryService.findAll();
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }

    @GetMapping("edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){

        Optional<Category> category= categoryService.findById(id);
        if (category.isPresent()){
            ModelAndView modelAndView= new ModelAndView("category/edit");
            modelAndView.addObject("category",category.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView= new ModelAndView("error.404");
            return modelAndView;
        }

    }
    @PostMapping("update-category")
    public ModelAndView update(@ModelAttribute Category category){
        ModelAndView modelAndView= new ModelAndView("category/list");
        categoryService.save(category);
        modelAndView.addObject("categories",categoryService.findAll());
        modelAndView.addObject("message","Updated successfully");
        return modelAndView;
    }

    @GetMapping("delete-category/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("category/list");
        categoryService.remove(id);
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
}
