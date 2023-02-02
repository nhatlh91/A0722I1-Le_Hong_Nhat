package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface CustomerService {
   public List<Customer> findAll();
   public void save(Customer customer);
   public Customer findById(int id);
   public void update(int id, Customer customer);
   public void remove(int id);
}
