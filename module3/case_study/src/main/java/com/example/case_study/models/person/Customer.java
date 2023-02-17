package com.example.case_study.models.person;

import java.util.Date;

public class Customer extends Person{
    int customer_id;
    int customer_type_id;
    int gender;

    public Customer() {
    }

    public Customer(String name, Date birthday, String id_card, String phone, String email, String address, int customer_id, int customer_type_id, int gender) {
        super(name, birthday, id_card, phone, email, address);
        this.customer_id = customer_id;
        this.customer_type_id = customer_type_id;
        this.gender = gender;
    }

    public Customer(String name, Date birthday, String id_card, String phone, String email, String address, int customer_type_id, int gender) {
        super(name, birthday, id_card, phone, email, address);
        this.customer_type_id = customer_type_id;
        this.gender = gender;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
