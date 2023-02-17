package com.example.case_study.repositories;

import com.example.case_study.models.person.Customer;
import com.example.case_study.models.person.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    @Override
    public void create(Employee employee) {

    }

    @Override
    public List<Employee> read(){
        List<Employee> employees = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("SELECT * FROM EMPLOYEE");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String id_card = resultSet.getString("employee_id_card");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int employee_id = resultSet.getInt("employee_id");
                    int position_id = resultSet.getInt("position_id");
                    int education_degree_id = resultSet.getInt("education_degree_id");
                    int division_id = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    Employee employee = new Employee(name,birthday,id_card,phone,email,address,employee_id,position_id,education_degree_id,division_id,username);
                    employees.add(employee);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            }
        }
        return employees;
    }

    @Override
    public Employee readById(int employee_id) {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(int employee_id) {

    }
}
