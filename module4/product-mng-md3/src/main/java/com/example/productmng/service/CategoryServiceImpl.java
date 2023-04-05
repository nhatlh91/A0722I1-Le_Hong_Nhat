package com.example.productmng.service;

import com.example.productmng.model.Category;
import com.example.productmng.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(new Category());
    }

    @Override
    public Category findByName(String categoryName) {
        return categoryRepository.findCategoryByCategoryNameEquals(categoryName);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
