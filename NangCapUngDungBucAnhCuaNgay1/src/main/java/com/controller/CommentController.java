package com.controller;

import com.model.Comment;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;



    @GetMapping("index")
    public ModelAndView index(@PageableDefault(value = 2) Pageable pageable){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.findAll(pageable));
        return modelAndView;
    }

    @PostMapping ("comment")
    public ModelAndView comment(@ModelAttribute Comment comment,Pageable pageable){
        ModelAndView modelAndView= new ModelAndView("index");
        comment.setLike(0);
        commentService.create(comment);
        modelAndView.addObject("comments",commentService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("doLike/{id}")
    public ModelAndView doLike(@PathVariable Long id,Pageable pageable){
        ModelAndView modelAndView= new ModelAndView("index");
        Optional<Comment> comment= commentService.findById(id);
        comment.get().setLike(comment.get().getLike() + 1);
        commentService.update(comment.get());
        modelAndView.addObject("comment",new Comment());
        modelAndView.addObject("comments",commentService.findAll(pageable));
        return modelAndView;
    }
}
