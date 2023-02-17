package com.example.case_study.repositories;

import com.example.case_study.models.person.Customer;
import com.example.case_study.models.person.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    void create(Employee employee);
    List<Employee> read();
    Employee readById(int employee_id);
    void update(Employee employee);
    void delete(int employee_id);
}
