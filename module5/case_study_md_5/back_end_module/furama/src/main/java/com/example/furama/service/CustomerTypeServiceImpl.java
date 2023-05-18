package com.example.furama.service;

import com.example.furama.entity.CustomerType;
import com.example.furama.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
@org.springframework.stereotype.Service
public class CustomerTypeServiceImpl implements Service<CustomerType> {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }

    @Override
    public CustomerType save(CustomerType customerType) {
        return customerTypeRepository.save(customerType);
    }

    @Override
    public Optional<CustomerType> findById(Long id) {
        return customerTypeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        customerTypeRepository.deleteById(id);
    }
}
