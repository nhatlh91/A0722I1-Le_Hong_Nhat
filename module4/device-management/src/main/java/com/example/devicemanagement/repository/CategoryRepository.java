package com.example.devicemanagement.repository;

import com.example.devicemanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByCategoryNameContainsOrCategoryDescContains(String categoryName, String categoryDesc);
}
