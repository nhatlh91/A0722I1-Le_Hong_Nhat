package com.example.case_study.models.person;

import java.util.Date;

public class Employee extends Person implements Comparable<Employee>{
    int employee_id;
    double salary;
    int position_id;
    int education_degree_id;
    int division_id;
    String username;

    public Employee() {
    }

    public Employee(int employee_id, String name, Date birthday, String id_card, String phone, String email, String address, double salary, int position_id, int education_degree_id, int division_id, String username) {
        super(name, birthday, id_card, phone, email, address);
        this.employee_id = employee_id;
        this.salary = salary;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
        this.username = username;
    }

    public Employee(String name, Date birthday, String id_card, String phone, String email, String address, double salary, int position_id, int education_degree_id, int division_id, String username) {
        super(name, birthday, id_card, phone, email, address);
        this.salary = salary;
        this.position_id = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id = division_id;
        this.username = username;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(Employee o) {
        return this.employee_id - o.employee_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", salary=" + salary +
                ", position_id=" + position_id +
                ", education_degree_id=" + education_degree_id +
                ", division_id=" + division_id +
                ", username='" + username +
                ", name='" + name +
                ", birthday=" + birthday +
                ", id_card='" + id_card +
                ", phone='" + phone +
                ", email='" + email +
                ", address='" + address +
                '}';
    }
}
