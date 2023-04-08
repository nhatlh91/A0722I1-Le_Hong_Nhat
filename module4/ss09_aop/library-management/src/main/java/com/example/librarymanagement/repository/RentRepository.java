package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentRepository extends JpaRepository<Rent,Long> {
    Optional<Rent> findByRentCode(String rentCode);
}
