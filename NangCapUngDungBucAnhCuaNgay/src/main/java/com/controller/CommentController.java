package com.controller;

import com.model.Comment;
import com.service.CommentService;
import com.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;



    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.findAll());
        return modelAndView;
    }

    @PostMapping ("comment")
    public ModelAndView comment(@ModelAttribute Comment comment){
        ModelAndView modelAndView= new ModelAndView("index");
        comment.setLike(0);
        commentService.create(comment);
        modelAndView.addObject("comments",commentService.findAll());
        return modelAndView;
    }

    @GetMapping("doLike/{id}")
    public ModelAndView doLike(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("index");
        Comment comment= commentService.findById(id);
        comment.setLike(comment.getLike() + 1);
        commentService.update(comment);
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.findAll());
        return modelAndView;
    }
}
