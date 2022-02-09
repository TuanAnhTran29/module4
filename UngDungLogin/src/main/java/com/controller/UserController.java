package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("login")
    public ModelAndView showLoginForm(){
        ModelAndView modelAndView= new ModelAndView("/demo");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("doLogin")
    public ModelAndView login(@ModelAttribute User user){
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            ModelAndView modelAndView= new ModelAndView("/dashboard");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        return new ModelAndView("/error");
    }
}
