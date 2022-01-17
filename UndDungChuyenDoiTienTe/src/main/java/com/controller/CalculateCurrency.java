package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculateCurrency {
    @GetMapping
    public ModelAndView show(){
        ModelAndView modelAndView= new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping("/main")
    public ModelAndView calculate(@RequestParam int inputNumber){
        ModelAndView modelAndView = new ModelAndView("index");
        int result= inputNumber * 23000;
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
