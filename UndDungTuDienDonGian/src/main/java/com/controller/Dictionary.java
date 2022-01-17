package com.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    @GetMapping
    public ModelAndView show(){
        ModelAndView modelAndView= new ModelAndView("index");
        return modelAndView;
    }


    @PostMapping("/dictionary")
    public ModelAndView translate(@RequestParam String inputText){
        ModelAndView modelAndView= new ModelAndView("index");
        Map<String,String> dictionary= new HashMap<>();
        dictionary.put("hello","Xin chào");
        dictionary.put("bird","Con chim");
        dictionary.put("cock","Con gà trống");
        dictionary.put("plan","Kế hoạch");

        String result= dictionary.get(inputText);
        if (result == null){
            modelAndView.addObject("message","Can not find this word");
        }else {
            modelAndView.addObject("message",result);
        }
        return modelAndView;
    }
}
