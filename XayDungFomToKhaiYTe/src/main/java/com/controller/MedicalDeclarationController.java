package com.controller;

import com.service.IMedicalDeclarationService;
import com.service.MedicalDeclarationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class MedicalDeclarationController {
    IMedicalDeclarationService medicalDeclarationService= new MedicalDeclarationService();
    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("medicals",medicalDeclarationService.findAll());
        return modelAndView;
    }
}
