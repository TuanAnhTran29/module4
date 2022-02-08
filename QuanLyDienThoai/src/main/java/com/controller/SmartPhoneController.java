package com.controller;

import com.model.SmartPhone;
import com.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone){
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED) ;
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones(){
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id){
        Optional<SmartPhone> smartPhone= smartPhoneService.findById(id);
        if (!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartPhone.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SmartPhone> showEditForm(@PathVariable Long id){
        Optional<SmartPhone> smartPhone= smartPhoneService.findById(id);
        if (!smartPhone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartPhone.get(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SmartPhone> updateSmartPhone(@PathVariable Long id, @RequestBody SmartPhone smartPhone){

        smartPhone.setId(id);
        System.out.println(smartPhone);
        return new ResponseEntity<>(smartPhoneService.save(smartPhone),HttpStatus.OK);
    }



}
