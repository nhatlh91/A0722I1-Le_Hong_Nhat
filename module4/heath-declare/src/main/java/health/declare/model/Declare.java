package health.declare.model;

import java.util.Date;

public class Declare {
    private String fullname;
    private int yearOfBirth;
    private String gender;
    private String national;
    private String id;
    private String transport;
    private String vehicleId;
    private String seatNumber;
    private String department;
    private String arrival;
    private String travelHistory;
    private String city;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String email;
    private String status;
    private String exposuringHistory;


    public Declare() {
    }

    public Declare(String fullname, int yearOfBirth, String gender, String national, String id, String transport, String vehicleId, String seatNumber, String department, String arrival, String travelHistory, String city, String district, String ward, String address, String phone, String email, String status, String exposuringHistory) {
        this.fullname = fullname;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.national = national;
        this.id = id;
        this.transport = transport;
        this.vehicleId = vehicleId;
        this.seatNumber = seatNumber;
        this.department = department;
        this.arrival = arrival;
        this.travelHistory = travelHistory;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.exposuringHistory = exposuringHistory;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(String travelHistory) {
        this.travelHistory = travelHistory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExposuringHistory() {
        return exposuringHistory;
    }

    public void setExposuringHistory(String exposuringHistory) {
        this.exposuringHistory = exposuringHistory;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    @Override
    public String toString() {
        return "Declare{" +
                "fullname='" + fullname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", gender='" + gender + '\'' +
                ", country='" + national + '\'' +
                ", id='" + id + '\'' +
                ", transport='" + transport + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", department=" + department +
                ", finish=" + arrival +
                ", city='" + travelHistory + '\'' +
                '}';
    }
}
