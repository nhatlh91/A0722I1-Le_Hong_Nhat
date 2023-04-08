package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Rent;

import java.util.List;

public interface RentService {
    public List<Rent> findAll();
    public Rent findById(Long id);
    public Rent findByRentCode(String rentCode);
    public Rent create(Rent rent);
    public void delete(Rent rent);
}
