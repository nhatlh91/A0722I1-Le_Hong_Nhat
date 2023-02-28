package com.example.thi.models;

import java.sql.Date;

public class Person {
    private int id;
    private String name;
    Date birthday;
    private int fid;

    public Person() {
    }

    public Person(int id, String name, Date birthday, int fid) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.fid = fid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getFid() {
        return fid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", fid=" + fid +
                '}';
    }
}
