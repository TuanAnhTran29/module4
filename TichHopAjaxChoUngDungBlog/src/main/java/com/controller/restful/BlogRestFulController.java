package com.controller.restful;

import com.model.Blog;
import com.model.BlogDTO;
import com.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/blogs")
public class BlogRestFulController {
    @Autowired
    private IBlogService blogService;
    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAll(){
        List<Blog> blogs= (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogs,HttpStatus.OK);
        }
    }

    @GetMapping("/dto")
    public ResponseEntity<?> findSAndC(){
        List<Blog> blogs= (List<Blog>) blogService.findAll();
        List<BlogDTO> blogDTOs= new ArrayList<>();
        for (Blog blog : blogs){
            BlogDTO blogDTO= new BlogDTO(blog.getSummary(), blog.getContent());
            blogDTOs.add(blogDTO);
        }
        return new ResponseEntity<>(blogDTOs,HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Iterable<Blog>> findByCategory(@PathVariable Long id){
        Iterable<Blog> blogs= blogService.findAll();
        List<Blog> blogIterable= new ArrayList<>();
        for (Blog blog: blogs){
            if (blog.getCategory().getId() == id){
                blogIterable.add(blog);
            }
        }
        return new ResponseEntity<>(blogIterable,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> viewDetailBlog(@PathVariable Long id){
        Optional<Blog> blog= blogService.findById(id);
        if (!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(),HttpStatus.OK);
    }

    @GetMapping("/limit/{limit}")
    public ResponseEntity<Iterable<Blog>> getBlogLimit(@PathVariable Integer limit){
        return new ResponseEntity<>(blogService.findBlogLimit(limit), HttpStatus.OK) ;
    }
}
