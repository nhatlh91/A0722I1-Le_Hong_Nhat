package com.example.casestudy.repository;

import com.example.casestudy.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentTypeRepository extends JpaRepository<RentType,Long> {
    Optional<RentType> findById(Long rentTypeId);
}
