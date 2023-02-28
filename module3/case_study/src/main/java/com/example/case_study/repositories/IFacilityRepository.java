package com.example.case_study.repositories;

import com.example.case_study.models.facility.Facility;
import com.example.case_study.models.facility.House;
import com.example.case_study.models.facility.Room;
import com.example.case_study.models.facility.Villa;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> listAllFacility(int service_type_id);
    Facility findById(int service_id);
    void addVilla(Villa villa);
    void addHouse(House house);
    void addRoom(Room room);
    void deleteFacility(int service_id);
    void editService(Facility facility);
    List<Facility> findByName(String keyword);
}
