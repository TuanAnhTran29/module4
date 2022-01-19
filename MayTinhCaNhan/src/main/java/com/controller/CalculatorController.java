package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping
    public String show(){
        return "index";
    }

    @PostMapping("calculate1")
    public ModelAndView calculate(@RequestParam("input1") int input1, @RequestParam("input2") int input2, @RequestParam("calculate") String calculate){
        ModelAndView modelAndView= new ModelAndView("index");
        int result= 0;
        switch (calculate){
            case "Addition":
                result= input1 + input2;
                break;
            case "Subtraction":
                result= input1 - input2;
                break;
            case "Multiplication":
                result= input1 * input2;
                break;
            case "Division":
                result= input1 / input2;
                break;
        }
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
