package models;

import java.time.LocalDate;

public class Customer extends Person{
    final String COMMA = ",";
    private String customerID;
    private String typeOfCustomer;
    private String address;

    public Customer(String name, LocalDate birthday, String gender, String id, String tel, String email, String typeOfCustomer, String address, String customerID) {
        super(name, birthday, gender, id, tel, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.customerID = customerID;
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

    public String toFile(){
        return this.getName()+COMMA+this.getBirthday()+COMMA+this.getGender()+COMMA+this.getId()+COMMA
                +this.getTel()+COMMA+this.getEmail()+COMMA+this.getTypeOfCustomer()+COMMA+this.getAddress()+COMMA+this.getCustomerID();
    }
}
