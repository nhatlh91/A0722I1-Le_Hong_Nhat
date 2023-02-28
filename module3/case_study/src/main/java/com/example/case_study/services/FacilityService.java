package com.example.case_study.services;

import com.example.case_study.models.facility.*;
import com.example.case_study.repositories.FacilityRepository;

import java.util.List;

public class FacilityService implements IFacilityService{
    private FacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public List<Facility> listAll(int service_type_id) {
        return facilityRepository.listAllFacility(service_type_id);
    }

    @Override
    public Facility findById(int service_id) {
        return facilityRepository.findById(service_id);
    }

    @Override
    public List<Facility> findByName(String keyword) {
        return facilityRepository.findByName(keyword);
    }

    @Override
    public void addFacility(Facility facility) {
        if (facility.getService_type_id() == 1) {
            facilityRepository.addVilla((Villa) facility);
        } else if (facility.getService_type_id() == 2) {
            facilityRepository.addHouse((House) facility);
        } else {
            facilityRepository.addRoom((Room) facility);
        }
    }

    @Override
    public void deleteFacility(int service_id) {
        facilityRepository.deleteFacility(service_id);
    }

    @Override
    public void editService(Facility facility) {
        facilityRepository.editService(facility);
    }
}
