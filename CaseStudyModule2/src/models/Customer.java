package models;

import java.util.Date;

public class Customer extends Person{
    private final int DIAMOND = 1;
    private final int PLATINUM = 2;
    private final int GOLD = 3;
    private final int SILVER = 4;
    private final int MEMBER = 5;
    private String customerID;
    private int typeOfCustomer;
    private String address;

    public Customer(String name, Date birthday, String gender, String id, String tel, String email, String customerID, int typeOfCustomer, String address) {
        super(name, birthday, gender, id, tel, email);
        this.customerID = customerID;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(int typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
