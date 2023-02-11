package com.example.product_management.service;

import com.example.product_management.models.Product;
import com.example.product_management.repository.IProductRepository;
import com.example.product_management.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    IProductRepository repository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        repository.update(id,product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Product view(int id) {
        return repository.view(id);
    }

    @Override
    public List<Product> searchbyName(String name) {
        return repository.searchbyName(name);
    }
}
