package com.example.product_management.repository;

import com.example.product_management.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> productList;
    static{
        productList = new ArrayList<>();
        productList.add(new Product(1,"iPhone 11",800,"High resolution camera","Apple"));
        productList.add(new Product(2,"Galaxy Note 22",600,"Big screen with pen","Samsung"));
        productList.add(new Product(3,"Reno 10",500,"Best selfie camera","Oppo"));
        productList.add(new Product(4,"Redmi Note 12",450,"Best PPP","Xiaomi"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
        for (Product product1 : productList) {
            if (product1.getId() == id) {
                productList.set(productList.indexOf(product1), product);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
            for(Product product1 : productList){
                if (product1.getId()==id) {
                    productList.remove(product1);
                    break;
                }
            }
        }

    @Override
    public Product view(int id) {
        int idx = 0;
        for(int i=1 ; i<productList.size() ; i++){
            if (productList.get(i).getId()==id) {
                idx = i;
            }
        }
        return productList.get(idx);
    }

    @Override
    public List<Product> searchbyName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(product);
            }
        }
        return result;
    }
}