package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    void create(Blog blog);
    void update(Blog blog);
    List<Blog> findAll();
    Blog findById(int id);
    void delete(int id);
}
