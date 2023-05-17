package com.example.librarymgmt.service;

import com.example.librarymgmt.entity.Company;
import com.example.librarymgmt.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class CompanyServiceImpl implements Service<Company>{
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }
    @Override
    public Company findById(Long id) {
        return null;
    }

    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
