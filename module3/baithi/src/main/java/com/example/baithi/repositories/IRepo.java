package com.example.baithi.repositories;

import com.example.baithi.models.Product;

import java.util.List;

public interface IRepo {
    void create(Product product);
    List<Product> read();
    Product detail(int id);
    void update(Product product);
    void delete(int id);
    List<Product> search(String keyword);
}
