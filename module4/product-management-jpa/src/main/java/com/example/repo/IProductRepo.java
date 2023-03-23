package com.example.repo;

import com.example.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepo extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByNameContains(String keyword);
    List<Product> findAll();
}
