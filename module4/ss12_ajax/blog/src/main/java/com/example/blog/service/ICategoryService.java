package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    void create(Category category);
    void update(Category category);
    List<Category> findAll();
    Category findById(Long id);
    void delete(Long id);
}
