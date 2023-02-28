package com.example.case_study.services;

import com.example.case_study.models.facility.Facility;
import com.example.case_study.models.person.Employee;

import java.util.List;

public interface IEmployeeService {
    void create(Employee employee);
    List<Employee> read();
    Employee readById(int employee_id);
    List<Employee> findByName(String keyword);
    void update(Employee employee);
    void delete(int employee_id);
    void createUsername(String username, String password);
}
