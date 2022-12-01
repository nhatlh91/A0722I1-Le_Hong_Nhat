package models;

import java.time.LocalDate;

public class Employee extends Person{
    private String staffID;
    private String academicLevel;
    private String position;
    private int salary;

    public Employee(String staffID, String name, LocalDate birthday, String gender, String id, String tel, String email, String academicLevel, String position, int salary) {
        super(name, birthday, gender, id, tel, email);
        this.staffID = staffID;
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    @Override
    public String toString() {
        return "StaffID= " + staffID + TAB + super.toString() + TAB + "AcademicLevel= " + academicLevel + TAB + "Position= " + position + TAB + "Salary= " + salary;
    }

    public String toFile(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",staffID,name,birthday,gender,id,tel,email,academicLevel,position,salary);
    }
}
