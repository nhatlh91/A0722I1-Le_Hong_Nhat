package com.example.productmng.service;

import com.example.productmng.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void delete(Long id);
    void deleteAll(Long[] ids);
}
