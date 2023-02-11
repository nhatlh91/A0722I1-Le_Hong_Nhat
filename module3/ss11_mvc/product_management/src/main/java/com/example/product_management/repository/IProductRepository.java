package com.example.product_management.repository;

import com.example.product_management.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
    Product view(int id);
    List<Product> searchbyName(String name);
}
