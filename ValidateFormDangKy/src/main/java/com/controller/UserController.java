package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("show")
    public ModelAndView showForm(){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("save")
    public String save(@Validated @ModelAttribute User user, BindingResult bindingResult){
        new User().validate(user,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }else {
            return "result";
        }
    }
}
