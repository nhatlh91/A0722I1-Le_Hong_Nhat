package com.example.thi.repos;

import com.example.thi.models.Family;
import com.example.thi.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepo implements IPersonRepo {
    @Override
    public void create(Person person) {

    }

    @Override
    public List<Person> read(int fid) {
        List<Person> people = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection!=null){
            try {
                statement = connection.prepareStatement("SELECT * FROM thanh_vien WHERE ma_ho_khau = ?");
                statement.setInt(1,fid);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("ho_ten");
                    Date birthday = resultSet.getDate("ngay_sinh");
                    people.add(new Person(id,name,birthday,fid));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
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
        return people;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }
}
