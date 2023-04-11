package com.example.shoppingcart.repository;

import com.example.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
