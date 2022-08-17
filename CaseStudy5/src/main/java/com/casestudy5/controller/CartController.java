package com.casestudy5.controller;

import com.casestudy5.dto.response.ResponseMessage;
import com.casestudy5.model.Cart;
import com.casestudy5.model.Product;
import com.casestudy5.model.User;
import com.casestudy5.service.IBillService;
import com.casestudy5.service.ICartSerivce;
import com.casestudy5.service.IProductService;
import com.casestudy5.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private ICartSerivce cartSerivce;

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IBillService billService;


    @GetMapping
    public ResponseEntity<Iterable<Cart>> findAllCart(){
        return new ResponseEntity<>(cartSerivce.findAll(),HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findCartByUserId(@PathVariable Long id){
        User user= userService.findById(id).get();

        return new ResponseEntity<>(cartSerivce.findByUser(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCart(@Valid @RequestBody Cart cart){
        return new ResponseEntity<>(cartSerivce.save(cart),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cart>> getCartById(@PathVariable Long id){
        return new ResponseEntity<>(cartSerivce.findById(id),HttpStatus.OK);
    }

    @PostMapping("/add/{pid}/{quantity}/{uid}")
    public ResponseEntity<?> addToCart(@PathVariable Long pid ,@PathVariable int quantity, @PathVariable Long uid){

        Product product= productService.findById(pid).get();

        User user= userService.findById(uid).get();

        cartSerivce.addToCart(product,quantity,user);

        return new ResponseEntity<>(new ResponseMessage("Product was added to cart successfully!"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}/{qty}")
    public ResponseEntity<?> updateCart(@PathVariable("qty") int qty,@PathVariable("id") Long id){
        if (qty > 0){
            cartSerivce.updateCart(qty,id);
            return new ResponseEntity<>(new ResponseMessage("Your product was updated!"),HttpStatus.OK);
        }else {
            cartSerivce.remove(id);
            return new ResponseEntity<>(new ResponseMessage("deleted"),HttpStatus.OK);
        }


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFromCart(@PathVariable Long id){
        Cart cart= cartSerivce.findById(id).get();
        Product product= cart.getProduct();
        product.setInventory(product.getInventory() + cart.getQuantity());
        productService.save(product);
        cartSerivce.remove(id);
        return new ResponseEntity<>(new ResponseMessage("Deleted successfully"),HttpStatus.OK);
    }

    @DeleteMapping("delete-cart/{id}")
    public ResponseEntity<?> deleteAllCart(@PathVariable Long id){
        cartSerivce.remove(id);
        return new ResponseEntity<>(new ResponseMessage("Deleted successfully"), HttpStatus.OK);
    }

}
