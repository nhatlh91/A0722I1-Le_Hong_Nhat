package com.example.productmng.repository;

import com.example.productmng.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryByCategoryNameEquals(String categoryName);
}
