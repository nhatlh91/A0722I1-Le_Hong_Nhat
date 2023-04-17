package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    void create(Blog blog);
    void update(Blog blog);
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findByTitle(String keyword);
    Blog findById(Long id);
    void delete(Long id);
}
