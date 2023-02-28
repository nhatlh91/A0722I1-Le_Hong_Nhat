package com.phong_tro.model;

import java.sql.Date;

public class Room {
    private int id;
    private String name;
    private String phone;
    private Date date;
    private int payment;
    private String note;

    public Room(int id, String name, String phone, Date date, int payment, String note) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.payment = payment;
        this.note = note;
    }

    public Room(String name, String phone, Date date, int payment, String note) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.payment = payment;
        this.note = note;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDate() {
        return date;
    }

    public int getPayment() {
        return payment;
    }

    public String getNote() {
        return note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", payment=" + payment +
                ", note='" + note + '\'' +
                '}';
    }
}
