package com.example.baithi.services;

import com.example.baithi.models.Product;

import java.util.List;

public interface IService {
    void create(Product product);
    List<Product> read();
    Product detail(int id);
    void update (Product product);
    void delete(int id);
    List<Product> search(String keyword);
}
