package com.controller;

import com.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private IUserService userService;

    private String getPrinciple(){
        String username="";
        Object principle= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principle instanceof UserDetails){
            username= ((UserDetails) principle).getUsername();
        }else {
            username= principle.toString();
        }
        return username;
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(){
        ModelAndView modelAndView= new ModelAndView("welcome");
        modelAndView.addObject("user",getPrinciple());
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView adminHomePage(){
        ModelAndView modelAndView= new ModelAndView("admin");
        modelAndView.addObject("user",getPrinciple());
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView userHomePage(){
        ModelAndView modelAndView= new ModelAndView("user");
        modelAndView.addObject("user",getPrinciple());
        return modelAndView;
    }

    @GetMapping("/403")
    public ModelAndView errorPage(){
        ModelAndView modelAndView= new ModelAndView("accessDenied");
        return modelAndView;
    }
}
