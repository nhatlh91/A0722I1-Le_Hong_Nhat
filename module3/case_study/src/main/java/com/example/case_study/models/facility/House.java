package com.example.case_study.models.facility;

public class House extends Facility{
    private String room_standard;
    private String description_other_convenience;
    private int number_of_floors;

    public House() {
    }

    public House(int id, String service_name, int service_area, double service_cost, int service_max_people, int rent_type_id, int service_type_id, String room_standard, String description_other_convenience, int number_of_floors) {
        super(id, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id);
        this.room_standard = room_standard;
        this.description_other_convenience = description_other_convenience;
        this.number_of_floors = number_of_floors;
    }

    public House(String service_name, int service_area, double service_cost, int service_max_people, int rent_type_id, int service_type_id, String room_standard, String description_other_convenience, int number_of_floors) {
        super(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id);
        this.room_standard = room_standard;
        this.description_other_convenience = description_other_convenience;
        this.number_of_floors = number_of_floors;
    }

    public String getRoom_standard() {
        return room_standard;
    }

    public void setRoom_standard(String room_standard) {
        this.room_standard = room_standard;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "room_standard='" + room_standard + '\'' +
                ", description_other_convenience='" + description_other_convenience + '\'' +
                ", number_of_floors=" + number_of_floors +
                '}';
    }
}
