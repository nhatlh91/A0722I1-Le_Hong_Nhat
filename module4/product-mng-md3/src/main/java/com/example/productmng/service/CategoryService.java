package com.example.productmng.service;

import com.example.productmng.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category save(Category category);

    Category findById(Long id);
    Category findByName(String categoryName);

    void delete(Category category);
}
