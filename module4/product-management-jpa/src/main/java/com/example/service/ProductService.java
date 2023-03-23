package com.example.service;

import com.example.model.Product;
import com.example.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    IProductRepo repo;
//    private static final Map<Integer, Product> products = new HashMap<>();
//
//    static {
//        products.put(1, new Product(1, "iPhone X", 15000000, "new design", "Apple"));
//        products.put(2, new Product(2, "Note 20", 25000000, "magic pen", "Samsung"));
//        products.put(3, new Product(3, "Reno 6", 17000000, "best selfie", "Oppo"));
//        products.put(4, new Product(4, "iPhone 14", 25000000, "4 cameras", "Apple"));
//        products.put(5, new Product(5, "K50 Pro", 20000000, "best for gaming", "Xiaomi"));
//    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Product> getList() {
        Iterable<Product> iterable = repo.findAll();
        List<Product> bookList = new ArrayList<>();
        for (Product p: iterable) {
            bookList.add(p);
        }
        return bookList;
    }

    public void update(Product product) {
        repo.save(product);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<Product> search(String keyword) {
        return repo.findByNameContains(keyword);
    }
}
