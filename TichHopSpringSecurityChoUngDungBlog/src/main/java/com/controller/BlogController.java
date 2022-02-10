package com.controller;

import com.model.Blog;
import com.model.Category;
import com.service.IBlogService;
import com.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("blog/index");
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView user(){
        ModelAndView modelAndView= new ModelAndView("blog/user");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin(){
        ModelAndView modelAndView= new ModelAndView("blog/admin");
        return modelAndView;
    }


    @GetMapping("/admin/create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("blog/create");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @PostMapping("/admin/create-blog")
    public ModelAndView post(@ModelAttribute Blog blog){
        ModelAndView modelAndView= new ModelAndView("blog/create");
        blogService.save(blog);
        modelAndView.addObject("message","Post blog successfully");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }

    @GetMapping("/list-blog")
    public ModelAndView list(@RequestParam("search") Optional<String> search, @PageableDefault(value = 3) Pageable pageable){
        ModelAndView modelAndView= new ModelAndView("blog/list");
        Iterable<Blog> blogs;
        if (search.isPresent()){
            blogs= blogService.findBlogsByTitleLike(search.get(),pageable);
        }else {
            blogs= blogService.findBlogLimit(2);
        }
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }


    @GetMapping("/admin/view-detail/{id}")
    public ModelAndView viewBlog(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("blog/view_detail");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("/admin/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("blog/edit");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/admin/update-blog")
    public ModelAndView update(@ModelAttribute Blog blog, Pageable pageable){
        ModelAndView modelAndView= new ModelAndView("blog/list");
        blogService.save(blog);
        modelAndView.addObject("blogs",blogService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/admin/delete-blog/{id}")
    public ModelAndView delete(@PathVariable Long id,Pageable pageable){
        ModelAndView modelAndView= new ModelAndView("blog/list");
        blogService.remove(id);
        modelAndView.addObject("blogs",blogService.findAll(pageable));
        return modelAndView;
    }
}
