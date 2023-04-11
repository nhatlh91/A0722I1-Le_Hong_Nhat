package com.example.shoppingcart.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public boolean checkItemInCart(Product product) {
        for (Product product1 : products.keySet()) {
            if (product1.equals(product)) {
                return true;
            }
        }
        return false;
    }

    public Set<Product> getProductList() {
        return products.keySet();
    }

    public Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().equals(product)) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            products.put(product, products.get(product) + 1);
        }
    }

    public void removeProduct(Product product) {
        if (product != null)
            products.remove(product);
    }

    public int countProductQuantity() {
        int productQuantity = 0;
        for (int i : products.values()) {
            productQuantity += i;
        }
        return productQuantity;
    }

    public int countItemQuantity() {
        return products.size();
    }

    public Double totalPayment() {
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }


}
