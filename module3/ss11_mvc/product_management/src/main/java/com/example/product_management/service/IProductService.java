package com.example.product_management.service;

import com.example.product_management.Product;

import java.util.List;

public interface IProductService {
        List<Product> findAll();
        void save(Product product);
        void update(int id, Product product);
        void delete(int id);
        Product view(int id);
}
