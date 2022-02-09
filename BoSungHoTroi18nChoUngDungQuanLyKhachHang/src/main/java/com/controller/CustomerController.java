package com.controller;

import com.model.Customer;
import com.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView findAllCustomer(){
        ModelAndView modelAndView= new ModelAndView("list");
        modelAndView.addObject("customers",customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id){
        Optional<Customer> customer= customerService.findById(id);
        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(customer.get(),HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Optional<Customer> customerOptional= customerService.findById(id);
        if (!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            customer.setId(customerOptional.get().getId());
            return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Optional<Customer> customerOptional= customerService.findById(id);
        if (!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            customerService.remove(id);
            return new ResponseEntity<>(customerOptional.get(),HttpStatus.NO_CONTENT);
        }
    }
}
