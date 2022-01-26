package com.controller;

import com.model.Track;
import com.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.rmi.MarshalledObject;

@Controller
public class TrackController {
    @Autowired
    private ITrackService trackService;

    @GetMapping("showCreate")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView= new ModelAndView("create");
        modelAndView.addObject("track",new Track());
        return modelAndView;
    }

    @PostMapping("create")
    public String save(@Valid @ModelAttribute Track track, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            System.out.println(1234);
            return "create";
        }else {
            trackService.save(track);
            System.out.println(123);
            model.addAttribute("tracks",trackService.findAll());
            return "list";
        }
    }

    @GetMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView= new ModelAndView("list");
        modelAndView.addObject("tracks",trackService.findAll());
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView= new ModelAndView("edit");
        modelAndView.addObject("track",trackService.findById(id));
        return modelAndView;
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute Track track, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }else {
            trackService.save(track);
            model.addAttribute("tracks",trackService.findAll());
            return "list";
        }
    }

}
