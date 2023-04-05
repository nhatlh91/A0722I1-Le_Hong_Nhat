package com.example.productmng.repository;

import com.example.productmng.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand findBrandByBrandNameEquals(String brandName);
}
