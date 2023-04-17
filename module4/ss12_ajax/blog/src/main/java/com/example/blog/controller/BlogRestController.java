package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    private IBlogService blogService;

    @Autowired
    BlogRestController(IBlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping()
    public ResponseEntity<List<Blog>> search(@RequestParam("keyword") String keyword){
        System.out.println(keyword);
        List<Blog> blogs = blogService.findByTitle(keyword);
        if(blogs.isEmpty()) {
            return new ResponseEntity<>(blogs, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
