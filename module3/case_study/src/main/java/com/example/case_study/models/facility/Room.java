package com.example.case_study.models.facility;

public class Room extends Facility{

    public Room() {
    }

    public Room(int id, String service_name, int service_area, double service_cost, int service_max_people, int rent_type_id, int service_type_id) {
        super(id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id);
    }

    public Room(String service_name, int service_area, double service_cost, int service_max_people, int rent_type_id, int service_type_id) {
        super(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id);
    }

    @Override
    public String toString() {
        return "Room{}";
    }
}
