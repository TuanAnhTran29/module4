package com.casestudy5.controller;

import com.casestudy5.dto.response.ResponseMessage;
import com.casestudy5.model.Bill;
import com.casestudy5.model.Cart;
import com.casestudy5.model.Product;
import com.casestudy5.model.User;
import com.casestudy5.service.IBillService;
import com.casestudy5.service.ICartSerivce;
import com.casestudy5.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private IBillService billService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICartSerivce cartSerivce;

    @GetMapping
    public ResponseEntity<Iterable<Bill>> findAll(){
        return new ResponseEntity<>(billService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBill(@RequestBody Bill bill){
        billService.save(bill);
        return new ResponseEntity<>(new ResponseMessage("Save bill success!"), HttpStatus.OK);
    }

    @PostMapping("/pay")
    public ResponseEntity<?> payBill(@RequestBody Bill bill){
        bill.setStatus("paid");
        billService.save(bill);
        return new ResponseEntity<>(new ResponseMessage("Save bill success!"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Bill>> findById(@PathVariable Long id){
        return new ResponseEntity<>(billService.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBill(@PathVariable Long id){
        billService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<Bill>> findAllByUserId(@PathVariable Long id){
        return new ResponseEntity<>(billService.findAllByUserId(id),HttpStatus.OK);
    }

//    @PostMapping("/create/{totalCost}/{userId}")
//    public ResponseEntity<?> createBill(@PathVariable int totalCost, @PathVariable Long userId){
//        User user= userService.findById(userId).get();
//        Date date= new Date();
//
//    }


}
