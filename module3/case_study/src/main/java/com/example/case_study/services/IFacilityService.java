package com.example.case_study.services;

import com.example.case_study.models.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> listAll(int service_type_id);
    Facility findById(int service_id);
    List<Facility> findByName(String keyword);
    void addFacility(Facility facility);
    void deleteFacility(int service_id);
    void editService(Facility facility);
}
