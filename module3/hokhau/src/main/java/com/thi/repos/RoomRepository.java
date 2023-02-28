package com.thi.repos;

import com.thi.model.Room;
import com.thi.ultils.DateUltil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class RoomRepository implements IRoomRepository{

    private static final String SELECT_ALL_ROOMS = "SELECT * FROM phong_tro";
    private static final String DELETE_BY_ID = "DELETE FROM phong_tro WHERE ma_phong_tro = ?";
    private static final String CREATE_ROOM = "INSERT INTO phong_tro(ten_nguoi_thue,so_dien_thoai,ngay_bat_dau,id_thanh_toan,ghi_chu) VALUE(?,?,?,?,?)";

    @Override
    public void create(Room room) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(CREATE_ROOM);
                statement.setString(1,room.getName());
                statement.setString(2,room.getPhone());
                statement.setString(3,DateUltil.parseString(room.getDate()));
                statement.setInt(4,room.getPayment());
                statement.setString(5,room.getNote());
                statement.execute();
                System.out.println(statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Room> read() {
        List<Room> rooms = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement(SELECT_ALL_ROOMS);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while(resultSet.next()){
                    int id = resultSet.getInt("ma_phong_tro");
                    String name = resultSet.getString("ten_nguoi_thue");
                    String phone = resultSet.getString("so_dien_thoai");
                    Date date = resultSet.getDate("ngay_bat_dau");
                    int payment = resultSet.getInt("id_thanh_toan");
                    String note = resultSet.getString("ghi_chu");
                    rooms.add(new Room(id,name,phone,date,payment,note));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rooms;
    }

    @Override
    public Room read(int id) {
        Room room = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement("SELECT * FROM phong_tro WHERE ma_phong_tro = ?");
                statement.setInt(1,id);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                    String name = resultSet.getString("ten_nguoi_thue");
                    String phone = resultSet.getString("so_dien_thoai");
                    Date date = resultSet.getDate("ngay_bat_dau");
                    int payment = resultSet.getInt("id_thanh_toan");
                    String note = resultSet.getString("ghi_chu");
                    room = new Room(id,name,phone,date,payment,note);
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
        return room;
    }

    @Override
    public void update(Room room) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement = connection.prepareStatement("UPDATE phong_tro SET ten_nguoi_thue = ? , so_dien_thoai = ? , ngay_bat_dau = ? , id_thanh_toan = ? , ghi_chu = ? WHERE ma_phong_tro = ?");
                statement.setString(1,room.getName());
                statement.setString(2,room.getPhone());
                statement.setDate(3,room.getDate());
                statement.setInt(4,room.getPayment());
                statement.setString(5,room.getNote());
                statement.setInt(6,room.getId());
                statement.executeUpdate();
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
    public void detele(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection!=null) {
            try {
                statement = connection.prepareStatement(DELETE_BY_ID);
                statement.setInt(1,id);
                statement.execute();
                System.out.println(statement);
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
    public List<Room> search(String keyword) {
        List<Room> rooms = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String pattern = "%"+keyword+"%";
        if (connection!=null){
            try {
                statement = connection.prepareStatement("SELECT * FROM phong_tro WHERE ten_nguoi_thue like ? OR so_dien_thoai like ? OR ma_phong_tro like ?");
                statement.setString(1,pattern);
                statement.setString(2,pattern);
                statement.setString(3,pattern);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()){
                    int id = resultSet.getInt("ma_phong_tro");
                    String name = resultSet.getString("ten_nguoi_thue");
                    String phone = resultSet.getString("so_dien_thoai");
                    Date date = resultSet.getDate("ngay_bat_dau");
                    int payment = resultSet.getInt("id_thanh_toan");
                    String note = resultSet.getString("ghi_chu");
                    rooms.add(new Room(id,name,phone,date,payment,note));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rooms;
    }
}
