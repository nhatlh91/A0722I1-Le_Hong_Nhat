package com.example.productmng.service;

import com.example.productmng.model.Brand;
import com.example.productmng.model.Category;
import com.example.productmng.repository.BrandRepository;
import com.example.productmng.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).orElse(new Brand());
    }

    @Override
    public Brand findByName(String brandName) {
        return brandRepository.findBrandByBrandNameEquals(brandName);
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }
}
