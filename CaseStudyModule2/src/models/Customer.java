package models;

import java.time.LocalDate;

public class Customer extends Person{
    private static int count = 0;
    private String customerID;
    private String typeOfCustomer;
    private String address;

    public Customer(String name, LocalDate birthday, String gender, String id, String tel, String email, String typeOfCustomer, String address) {
        super(name, birthday, gender, id, tel, email);
        this.customerID = "Customer"+ ++count;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() +
                "customerID='" + customerID + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
