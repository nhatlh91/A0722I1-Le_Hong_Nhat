package com.example.casestudy.service;

import com.example.casestudy.model.Facility;
import com.example.casestudy.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;

@org.springframework.stereotype.Service
public class FacilityServiceImpl implements Service<Facility> {
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public void delete(Long id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> search(String keyword, Pageable pageable) {
        return facilityRepository.findAllByName(keyword, pageable);
    }

    public Page<Facility> multipleFieldSearch(String keyword, Pageable pageable) {
        String name = keyword;
        String otherConvenience = keyword;
        Integer cost;
        try {
            cost = Integer.valueOf(keyword);
        } catch (NumberFormatException e) {
            cost = null;
        }
        return facilityRepository.findAllByNameContainingOrCostIsLessThanEqualOrOtherConvenienceContaining(name, cost, otherConvenience, pageable);
    }
}
