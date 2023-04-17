package com.example.smartphonemanagement.repository;

import com.example.smartphonemanagement.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
}
