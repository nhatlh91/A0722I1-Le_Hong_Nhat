package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "iPhone X", 15000000, "new design", "Apple"));
        products.put(2, new Product(2, "Note 20", 25000000, "magic pen", "Samsung"));
        products.put(3, new Product(3, "Reno 6", 17000000, "best selfie", "Oppo"));
        products.put(4, new Product(4, "iPhone 14", 25000000, "4 cameras", "Apple"));
        products.put(5, new Product(5, "K50 Pro", 20000000, "best for gaming", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) products.values();
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        if (products.containsKey(product.getId())) {
            products.replace(product.getId(), product);
        } else {
            products.put(product.getId(), product);
        }
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
