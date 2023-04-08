package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Rent;
import com.example.librarymanagement.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService{

    @Autowired
    RentRepository rentRepository;

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent findById(Long id) {
        return rentRepository.findById(id).orElse(new Rent());
    }
    public Rent findByRentCode(String rentCode) {
        return rentRepository.findByRentCode(rentCode).orElse(null);
    }

    @Override
    public Rent create(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public void delete(Rent rent) {
        rentRepository.delete(rent);
    }
}
