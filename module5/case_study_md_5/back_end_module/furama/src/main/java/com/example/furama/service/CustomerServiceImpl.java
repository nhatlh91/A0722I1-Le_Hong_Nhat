package com.example.furama.service;

import com.example.furama.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
@org.springframework.stereotype.Service
public class CustomerServiceImpl implements Service<Customer> {
    @Autowired
    private CustomerServiceImpl customerService;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerService.findAll(pageable);
    }

    @Override
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerService.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        customerService.deleteById(id);
    }
}
