package com.controller;


import com.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public ModelAndView showForm(){
        ModelAndView modelAndView= new ModelAndView("employee/create");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute("employee") Employee employee){
        ModelAndView modelAndView= new ModelAndView("employee/info");
        modelAndView.addObject("name",employee.getName());
        modelAndView.addObject("contactNumber",employee.getContactNumber());
        modelAndView.addObject("id",employee.getId());
        return modelAndView;
    }
}
