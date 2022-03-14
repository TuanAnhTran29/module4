package com.casestudy4.controller;

import com.casestudy4.model.Category;
import com.casestudy4.model.Song;
import com.casestudy4.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> listCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>("Created Song Successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category ,@PathVariable Long id){
        Optional<Category> categoryOptional= categoryService.findById(id);
        if (!categoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            category.setId(categoryOptional.get().getId());
            categoryService.save(category);
            return new ResponseEntity<>("Updated Song Successfully!", HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        Optional<Category> categoryOptional= categoryService.findById(id);
        if (categoryOptional.isPresent()){
            categoryService.remove(categoryOptional.get().getId());
            return new ResponseEntity<>("Deleted song successfully!", HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
