package com.example.case_study.services;

import com.example.case_study.models.person.Employee;
import com.example.case_study.repositories.EmployeeRepository;
import com.example.case_study.repositories.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    private IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public void create(Employee employee) {
        employeeRepository.create(employee);
    }

    @Override
    public List<Employee> read() {
        return employeeRepository.read();
    }

    @Override
    public Employee readById(int employee_id) {
        return employeeRepository.readById(employee_id);
    }

    @Override
    public List<Employee> findByName(String keyword) {

        return employeeRepository.findByName(keyword);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);
    }

    @Override
    public void delete(int employee_id) {
        employeeRepository.delete(employee_id);
    }

    @Override
    public void createUsername(String username, String password) {
        employeeRepository.createUser(username,password);
    }
}
