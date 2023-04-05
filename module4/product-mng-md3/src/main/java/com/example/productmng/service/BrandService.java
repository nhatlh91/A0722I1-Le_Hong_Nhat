package com.example.productmng.service;

import com.example.productmng.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();

    Brand save(Brand brand);

    Brand findById(Long id);

    Brand findByName(String brandName);

    void delete(Brand brand);
}
