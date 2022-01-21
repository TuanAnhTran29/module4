package com.controller;

import com.model.MedicalDeclaration;
import com.model.Symptom;
import com.service.IMedicalDeclarationService;
import com.service.ISymptomService;
import com.service.MedicalDeclarationService;
import com.service.SymptomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MedicalDeclarationController {
    ISymptomService symptomService= new SymptomService();
    IMedicalDeclarationService medicalDeclarationService= new MedicalDeclarationService();

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("medicals",medicalDeclarationService.findAll());
        modelAndView.addObject("symptoms",symptomService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView create(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("medical", new MedicalDeclaration());
        modelAndView.addObject("symptoms",symptomService.findAll());
        modelAndView.addObject("symptom",new ArrayList<Symptom>());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView save(@ModelAttribute MedicalDeclaration medical){
        ModelAndView modelAndView= new ModelAndView("index");
        medicalDeclarationService.save(medical);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("update");
        MedicalDeclaration medicalDeclaration= medicalDeclarationService.findById(id);
        modelAndView.addObject("medical",medicalDeclaration);
        return modelAndView;
    }

    @PostMapping("update")
    public String update(@ModelAttribute MedicalDeclaration medical){
        medicalDeclarationService.update(medical.getId(), medical);
        return "redirect:";
    }

}
