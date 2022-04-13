package com.casestudy5.controller;

import com.casestudy5.dto.response.ResponseMessage;
import com.casestudy5.model.Turnover;
import com.casestudy5.service.ITurnoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("api/turnover")
@CrossOrigin(origins = "*")
public class TurnoverController {

    @Autowired
    private ITurnoverService turnoverService;

    @GetMapping
    public ResponseEntity<Iterable<Turnover>> findAll(){
        return new ResponseEntity<>(turnoverService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Turnover turnover){
        return new ResponseEntity<>(turnoverService.save(turnover),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turnover>> findById(@PathVariable Long id){
        Optional<Turnover> turnover= turnoverService.findById(id);
        if(!turnover.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(turnover,HttpStatus.OK);
        }
    }

    @PostMapping("/save/{id}")
    public ResponseEntity<?> save(@PathVariable Long id, @RequestBody Turnover turnover){
        turnoverService.save(id,turnover);
        return new ResponseEntity<>(new ResponseMessage("Saved"),HttpStatus.OK);
    }
}
