package com.example.thi.repos;

import com.example.thi.models.Family;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyRepo implements IFamilyRepo {
    @Override
    public void create(Family person) {

    }

    @Override
    public List<Family> read() {
        List<Family> families = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection!=null){
            try {
                statement = connection.prepareStatement("SELECT * FROM ho_khau");
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()){
                    int fid = resultSet.getInt("ma_ho_khau");
                    String host = resultSet.getString("ten_chu_ho");
                    int number = resultSet.getInt("so_luong");
                    Date createDate = resultSet.getDate("ngay_tao");
                    String address = resultSet.getString("dia_chi");
                    families.add(new Family(fid,host,number,createDate,address));
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
        return families;
    }

    @Override
    public Family read(int fid) {
        Family family = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection!=null){
            try {
                statement = connection.prepareStatement("SELECT * FROM ho_khau WHERE ma_ho_khau = ?");
                statement.setInt(1,fid);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()){
                    String host = resultSet.getString("ten_chu_ho");
                    int number = resultSet.getInt("so_luong");
                    Date createDate = resultSet.getDate("ngay_tao");
                    String address = resultSet.getString("dia_chi");
                    family = new Family(fid,host,number,createDate,address);
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
        return family;
    }

    @Override
    public void update(Family family) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("UPDATE ho_khau SET ten_chu_ho = ? , ngay_tao = ? , dia_chi = ? WHERE ma_ho_khau = ?");
                statement.setString(1, family.getHost());
                statement.setDate(2, family.getCreateDate());
                statement.setString(3, family.getAddress());
                statement.setInt(4, family.getFid());
                statement.executeUpdate();
                System.out.println(statement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
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
    public void delete(Family person) {

    }
}
