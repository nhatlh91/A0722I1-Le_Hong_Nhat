package com.example.case_study.repositories;

import com.example.case_study.models.facility.Facility;
import com.example.case_study.models.person.Employee;

import java.util.List;

public interface IEmployeeRepository {
    void create(Employee employee);
    List<Employee> read();
    Employee readById(int employee_id);
    List<Employee> findByName(String keyword);
    void update(Employee employee);
    void delete(int employee_id);
    void createUser(String username, String password);
}
