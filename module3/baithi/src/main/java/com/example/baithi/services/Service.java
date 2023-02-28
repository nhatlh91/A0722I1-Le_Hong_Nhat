package com.example.baithi.services;

import com.example.baithi.models.Product;
import com.example.baithi.repositories.IRepo;
import com.example.baithi.repositories.Repo;

import java.util.List;

public class Service implements IService{
    private IRepo repo = new Repo();
    @Override
    public void create(Product product) {
        repo.create(product);
    }

    @Override
    public List<Product> read() {
        return repo.read();
    }

    @Override
    public Product detail(int id) {
        return repo.detail(id);
    }

    @Override
    public void update(Product product) {
        repo.update(product);
    }

    @Override
    public void delete(int id) {
       repo.delete(id);
    }

    @Override
    public List<Product> search(String keyword) {
        return repo.search(keyword);
    }
}
