package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @PostMapping("save")
    public String save(@RequestParam("condiment")String[] condiment,ModelMap modelMap){
        modelMap.addAttribute("condiments",condiment);
        return "index";
    }

    @GetMapping
    public String show(){
        return "index";
    }

}
