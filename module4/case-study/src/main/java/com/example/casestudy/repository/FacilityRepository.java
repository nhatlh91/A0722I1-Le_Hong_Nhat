package com.example.casestudy.repository;

import com.example.casestudy.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility,Long> {
    Page<Facility> findAll(Pageable pageable);
    Page<Facility> findAllByName(String keyword, Pageable pageable);
    Page<Facility> findAllByNameContainingOrCostIsLessThanEqualOrOtherConvenienceContaining(String name, Integer cost, String otherConvenience, Pageable pageable);

}
