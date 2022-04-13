package com.casestudy5.controller;

import com.casestudy5.dto.custom.CartWithInventoryDTO;
import com.casestudy5.dto.custom.CartWithInventoryDTO1;
import com.casestudy5.service.serviceDTO.IServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dto")
@CrossOrigin(origins = "*")
public class DTOController {

    @Autowired
    private IServiceDTO serviceDTO;

    @GetMapping("/cartWithInventory")
    public ResponseEntity<List<CartWithInventoryDTO>> findAll(@RequestParam(value = "cid", required = false) Long id,@RequestParam(value = "quantity",required = false) Integer quantity){
        return new ResponseEntity<>(serviceDTO.getAllCartWithInventory(id,quantity), HttpStatus.OK);
    }

    @GetMapping("/cartWithInventory1")
    public ResponseEntity<List<CartWithInventoryDTO1>> findAll1(@RequestParam(value = "cid", required = false) Long cid, @RequestParam(value = "quantity", required = false) Integer quantity){
        return new ResponseEntity<>(serviceDTO.findAll(cid,quantity), HttpStatus.OK);
    }


}
