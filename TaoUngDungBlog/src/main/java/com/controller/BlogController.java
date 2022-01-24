package com.controller;

import com.model.Blog;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;


    @GetMapping("create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @PostMapping("create-blog")
    public ModelAndView post(@ModelAttribute Blog blog){
        ModelAndView modelAndView= new ModelAndView("create");
        blogService.save(blog);
        modelAndView.addObject("message","Post blog successfully");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @GetMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView= new ModelAndView("list");
        modelAndView.addObject("blogs",blogService.findAll());
        return modelAndView;
    }
    @GetMapping("view-detail/{id}")
    public ModelAndView viewBlog(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("view_detail");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("edit");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("update")
    public ModelAndView update(@ModelAttribute Blog blog){
        ModelAndView modelAndView= new ModelAndView("list");
        blogService.save(blog);
        modelAndView.addObject("blogs",blogService.findAll());
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("list");
        blogService.remove(id);
        modelAndView.addObject("blogs",blogService.findAll());
        return modelAndView;
    }
}
