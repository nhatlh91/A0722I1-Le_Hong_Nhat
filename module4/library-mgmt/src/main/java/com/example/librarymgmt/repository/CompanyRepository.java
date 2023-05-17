package com.example.librarymgmt.repository;

import com.example.librarymgmt.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
