package models;

import java.util.Date;

public class Booking {
    private int id;
    private String bookingID;
    private Date checkinDate;
    private Date checkoutDate;
    private String customerID;
    private String serviceName;
    private String typeOfService;

    public Booking(String bookingID, Date checkinDate, Date checkoutDate, String customerID, String serviceName, String typeOfService) {
        this.bookingID = bookingID;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }
}
