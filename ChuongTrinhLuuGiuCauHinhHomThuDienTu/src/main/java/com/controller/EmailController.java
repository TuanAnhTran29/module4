package com.controller;


import com.model.Email;
import com.service.EmailService;
import com.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    private final IEmailService emailService= new EmailService();

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("emails",emailService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("email",new Email());
        return modelAndView;
    }

    @PostMapping("save")
    public ModelAndView save(@ModelAttribute Email email){
        ModelAndView modelAndView= new ModelAndView("create");
        emailService.save(email);
        System.out.println(email);
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id){
        ModelAndView modelAndView= new ModelAndView("update");
        modelAndView.addObject("email",emailService.findById(id));
        return modelAndView;
    }

    @PostMapping("update")
    public String update(@ModelAttribute Email email){
        emailService.update(email.getId(),email);
        return "redirect:/index";
    }


}
