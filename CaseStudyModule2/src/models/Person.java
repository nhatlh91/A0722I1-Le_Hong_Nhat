package models;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person {
    private String name;
    private LocalDate birthday;
    private String gender;
    private String id;
    private String tel;
    private String email;

    public Person(String name, LocalDate birthday, String gender, String id, String tel, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id = id;
        this.tel = tel;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'';
    }
}
