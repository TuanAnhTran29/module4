package com.casestudy5.controller;

import com.casestudy5.dto.response.ResponseMessage;
import com.casestudy5.model.Cart;
import com.casestudy5.model.Product;
import com.casestudy5.service.ICartSerivce;
import com.casestudy5.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICartSerivce cartSerivce;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(){
        return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@Valid @RequestBody Product product){
        if (product.getInventory() != 0){
            return new ResponseEntity<>(productService.save(product),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new ResponseMessage("Inventory must be more than 1"), HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product ,@PathVariable Long id){
        Optional<Product> productOptional= productService.findById(id);
        if (!productOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            product.setId(productOptional.get().getId());
            productService.save(product);
            return new ResponseEntity<>(new ResponseMessage("Updated product successfully!"),HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.remove(id);
        cartSerivce.deleteCartByProductId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/category/product/{id}")
    public ResponseEntity<?> findProductAndCategory(@PathVariable Long id){
        productService.findProductAndCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> findAllProductByName(@PathVariable String keyword){
        if (productService.findAllProductByName(keyword).isEmpty()){
            return new ResponseEntity<>(new ResponseMessage("No search results!"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(productService.findAllProductByName(keyword),HttpStatus.OK);
        }
    }

}
