package models;

import java.time.LocalDate;

public class Booking {
    private String bookingID;
    private LocalDate checkin;
    private LocalDate checkout;
    private String customerID;

    private String facilityName;
    private String typeOfFacility;
    private LocalDate bookingDay;
    private final String COMMA = ",";

    public Booking(String bookingID, LocalDate checkin, LocalDate checkout, String customerID, String facilityName, String typeOfFacility, LocalDate bookingDay) {
        this.bookingID = bookingID;
        this.checkin = checkin;
        this.checkout = checkout;
        this.customerID = customerID;
        this.facilityName = facilityName;
        this.typeOfFacility = typeOfFacility;
        this.bookingDay = bookingDay;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getTypeOfFacility() {
        return typeOfFacility;
    }

    public void setTypeOfFacility(String typeOfFacility) {
        this.typeOfFacility = typeOfFacility;
    }

    public LocalDate getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(LocalDate bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String toString() {
        return " Booking ID: " + bookingID + COMMA + " Check-in: " + checkin + COMMA + " Check-out: " + checkout + COMMA +
                " Customer ID: " + customerID + COMMA + " Facility name: " + facilityName + COMMA + " Facility type: " + typeOfFacility + COMMA + " Booking day: " + bookingDay;
    }

    public String toFile(){
        return String.format("%s,%s,%s,%s,%s,%s,%s",bookingID,checkin,checkout,customerID,facilityName,typeOfFacility,bookingDay);
    }
}
