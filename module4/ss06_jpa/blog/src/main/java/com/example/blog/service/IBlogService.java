package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);
    void update(Blog blog);
    Page<Blog> findAll(Pageable pageable);
    Blog findById(int id);
    void delete(int id);
}
