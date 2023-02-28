package com.example.case_study.repositories;

import com.example.case_study.models.facility.Facility;
import com.example.case_study.models.facility.House;
import com.example.case_study.models.facility.Room;
import com.example.case_study.models.facility.Villa;
import com.example.case_study.models.person.Employee;
import com.example.case_study.utils.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM EMPLOYEE";
    private static final String ADD_EMPLOYEE = "insert into employee(employee_name,employee_birthday,employee_id_card,employee_phone,employee_email,employee_address,employee_salary,position_id,education_degree_id,division_id,username) value(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT * FROM employee where employee_id=?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id=?";
    private static final String UPDATE_EMPLOYEE = "UPDATE EMPLOYEE SET employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_phone = ?, employee_email = ?, employee_address = ?, employee_salary = ?, position_id = ?,education_degree_id = ?, division_id = ? WHERE employee_id=?";

    @Override
    public void create(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection!=null) {
            try {
                statement = connection.prepareStatement(ADD_EMPLOYEE);
                statement.setString(1, employee.getName());
                statement.setString(2, DateUtil.parseString(employee.getBirthday()));
                statement.setString(3, employee.getId_card());
                statement.setString(4, employee.getPhone());
                statement.setString(5, employee.getEmail());
                statement.setString(6, employee.getAddress());
                statement.setDouble(7, employee.getSalary());
                statement.setInt(8, employee.getPosition_id());
                statement.setInt(9, employee.getEducation_degree_id());
                statement.setInt(10, employee.getDivision_id());
                statement.setString(11, employee.getUsername());
                statement.execute();
                System.out.println("Them employee vao DB thanh cong");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Employee> read(){
        List<Employee> employees = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()) {
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String id_card = resultSet.getString("employee_id_card");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    double salary = resultSet.getDouble("employee_salary");
                    int employee_id = resultSet.getInt("employee_id");
                    int position_id = resultSet.getInt("position_id");
                    int education_degree_id = resultSet.getInt("education_degree_id");
                    int division_id = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    Employee employee = new Employee(employee_id, name, birthday, id_card, phone, email, address, salary, position_id, education_degree_id, division_id, username);
                    employees.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return employees;
    }

    @Override
    public Employee readById(int employee_id) {
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
                statement.setInt(1,employee_id);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()) {
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String id_card = resultSet.getString("employee_id_card");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    double salary = resultSet.getDouble("employee_salary");
                    int position_id = resultSet.getInt("position_id");
                    int education_degree_id = resultSet.getInt("education_degree_id");
                    int division_id = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    employee = new Employee(employee_id, name, birthday, id_card, phone, email, address, salary, position_id, education_degree_id, division_id, username);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return employee;
    }

    @Override
    public List<Employee> findByName(String keyword) {
        List<Employee> employees = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String pattern = "%"+keyword+"%";
        if (connection!=null) {
            try {
                statement = connection.prepareStatement("SELECT * FROM employee WHERE employee_name like ?");
                statement.setString(1,pattern);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()) {
                    int employee_id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    Date birthday = resultSet.getDate("employee_birthday");
                    String id_card = resultSet.getString("employee_id_card");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    double salary = resultSet.getDouble("employee_salary");
                    int position_id = resultSet.getInt("position_id");
                    int education_degree_id = resultSet.getInt("education_degree_id");
                    int division_id = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");
                    Employee employee = new Employee(employee_id, name, birthday, id_card, phone, email, address, salary, position_id, education_degree_id, division_id, username);
                    employees.add(employee);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return employees;
    }

    @Override
    public void update(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection!=null) {
            try {
                statement = connection.prepareStatement(UPDATE_EMPLOYEE);
                statement.setString(1, employee.getName());
                statement.setString(2, DateUtil.parseString(employee.getBirthday()));
                statement.setString(3, employee.getId_card());
                statement.setString(4, employee.getPhone());
                statement.setString(5, employee.getEmail());
                statement.setString(6, employee.getAddress());
                statement.setDouble(7, employee.getSalary());
                statement.setInt(8, employee.getPosition_id());
                statement.setInt(9, employee.getEducation_degree_id());
                statement.setInt(10, employee.getDivision_id());
                statement.setInt(11, employee.getEmployee_id());
                statement.executeUpdate();
                System.out.println(statement);
                System.out.println("Update employee vao DB thanh cong");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(int employee_id) {
        deleteUser(employee_id);
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(DELETE_EMPLOYEE);
                statement.setInt(1,employee_id);
                statement.execute();
                System.out.println(statement);
                System.out.println("Da xoa employee khoi Database");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void deleteUser(int employee_id) {
    Connection connection = DBConnection.getConnection();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String username = null;
    if(connection!= null){
        try {
            statement = connection.prepareStatement("SELECT username FROM employee WHERE employee_id=?");
            statement.setInt(1,employee_id);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                username = resultSet.getString("username");
                statement = connection.prepareStatement("DELETE FROM user WHERE username=?");
                statement.setString(1,username);
                System.out.println(statement);
                statement.execute();
                System.out.println("Da xoa username khoi table user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    }

    @Override
    public void createUser(String username, String password) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection!=null) {
            try {
                statement = connection.prepareStatement("INSERT INTO user(username,password) value(?,?)");
                statement.setString(1, username);
                statement.setString(2, password);
                statement.execute();
                System.out.println("Tao username thành công");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
