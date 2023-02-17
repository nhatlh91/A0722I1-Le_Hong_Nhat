package com.example.case_study.repositories;

import com.example.case_study.models.facility.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String UPDATE_ROOM = "update service set service_name = ?, service_area = ?, service_cost = ?, service_max_people = ?, rent_type_id = ?, standard_room = ? where service_id = ?";
    private static final String UPDATE_HOUSE = "update service set service_name = ?, service_area = ?, service_cost = ?, service_max_people = ?, rent_type_id = ?, standard_room = ?, description_other_convenience = ?,number_of_floors = ? where service_id = ?";
    private static final String UPDATE_VILLA = "update service set service_name = ?, service_area = ?, service_cost = ?, service_max_people = ?, rent_type_id = ?, standard_room = ?, description_other_convenience = ?,pool_area = ?, number_of_floors = ? where service_id = ?";
    private static final String SELECT_SERVICE_BY_TYPE = "call select_service_by_type(?)";
    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id = ?";
    private static final String ADD_VILLA = "INSERT INTO service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id,standard_room, description_other_convenience, pool_area, number_of_floors) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String ADD_HOUSE = "INSERT INTO service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id,standard_room, description_other_convenience, number_of_floors) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String ADD_ROOM = "INSERT INTO service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id) VALUES(?,?,?,?,?,?)";
    private static final String DELETE_SERVICE_BY_ID = "delete from service where service_id = ?";

    @Override
    public List<Facility> listAllFacility(int service_type_id) {
        List<Facility> facilities = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        if (connection!=null){
            try {
                statement = connection.prepareCall(SELECT_SERVICE_BY_TYPE);
                statement.setInt(1,service_type_id);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()){
                    int service_id = resultSet.getInt("service_id");
                    String service_name = resultSet.getString("service_name");
                    int service_area = resultSet.getInt("service_area");
                    double service_cost = resultSet.getDouble("service_cost");
                    int service_max_people = resultSet.getInt("service_max_people");
                    int rent_type_id = resultSet.getInt("rent_type_id");
                    String room_standard = resultSet.getString("standard_room");
                    String description_other_convenience = resultSet.getString("description_other_convenience");
                    double pool_area = resultSet.getDouble("pool_area");
                    int number_of_floors = resultSet.getInt("number_of_floors");
                    switch (service_type_id) {
                        case 1:
                            Villa villa = new Villa(service_id, service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,room_standard,
                                    description_other_convenience, pool_area, number_of_floors);
                            facilities.add(villa);
                            break;
                        case 2:
                            House house = new House(service_id, service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,room_standard,
                                    description_other_convenience, number_of_floors);
                            facilities.add(house);
                            break;
                        case 3:
                            Room room = new Room(service_id, service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id);
                            facilities.add(room);
                            break;
                    }
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
        return facilities;
    }

    @Override
    public Facility findById(int service_id) {
        Facility facility = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection!=null) {
            try {
                statement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
                statement.setInt(1,service_id);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()) {
                    int service_type_id = resultSet.getInt("service_type_id");
                    String service_name = resultSet.getString("service_name");
                    int service_area = resultSet.getInt("service_area");
                    double service_cost = resultSet.getDouble("service_cost");
                    int service_max_people = resultSet.getInt("service_max_people");
                    int rent_type_id = resultSet.getInt("rent_type_id");
                    String room_standard;
                    String description_other_convenience;
                    double pool_area;
                    int number_of_floors;
                    switch (service_type_id) {
                        case 1:
                            room_standard = resultSet.getString("standard_room");
                            description_other_convenience = resultSet.getString("description_other_convenience");
                            pool_area = resultSet.getDouble("pool_area");
                            number_of_floors = resultSet.getInt("number_of_floors");
                            facility = new Villa(service_id, service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,room_standard,
                                    description_other_convenience, pool_area, number_of_floors);
                            break;
                        case 2:
                            room_standard = resultSet.getString("standard_room");
                            description_other_convenience = resultSet.getString("description_other_convenience");
                            number_of_floors = resultSet.getInt("number_of_floors");
                            facility = new House(service_id, service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,room_standard,
                                    description_other_convenience, number_of_floors);
                            break;
                        case 3:
                            facility = new Room(service_id, service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id);
                            break;
                    }
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
        return facility;
    }

    @Override
    public void addVilla(Villa villa) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_VILLA);
            statement.setString(1, villa.getService_name());
            statement.setInt(2, villa.getService_area());
            statement.setDouble(3, villa.getService_cost());
            statement.setInt(4, villa.getService_max_people());
            statement.setInt(5, villa.getRent_type_id());
            statement.setInt(6, 1);
            statement.setString(7, villa.getRoom_standard());
            statement.setString(8, villa.getDescription_other_convenience());
            statement.setDouble(9, villa.getPool_area());
            statement.setInt(10, villa.getNumber_of_floors());
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

    @Override
    public void addHouse(House house) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_HOUSE);
            statement.setString(1, house.getService_name());
            statement.setInt(2, house.getService_area());
            statement.setDouble(3, house.getService_cost());
            statement.setInt(4, house.getService_max_people());
            statement.setInt(5, house.getRent_type_id());
            statement.setInt(6, 2);
            statement.setString(7, house.getRoom_standard());
            statement.setString(8, house.getDescription_other_convenience());
            statement.setInt(9, house.getNumber_of_floors());
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

    @Override
    public void addRoom(Room room) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_ROOM);
            statement.setString(1, room.getService_name());
            statement.setInt(2, room.getService_area());
            statement.setDouble(3, room.getService_cost());
            statement.setInt(4, room.getService_max_people());
            statement.setInt(5, room.getRent_type_id());
            statement.setInt(6, 3);
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

    @Override
    public void deleteFacility(int service_id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_SERVICE_BY_ID);
                statement.setInt(1,service_id);
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
    public void editService(Facility facility) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            switch (facility.getService_type_id()) {
                case 1:
                    Villa villa = (Villa) facility;
                    statement = connection.prepareStatement(UPDATE_VILLA);
                    statement.setString(1, villa.getService_name());
                    statement.setInt(2, villa.getService_area());
                    statement.setDouble(3, villa.getService_cost());
                    statement.setInt(4, villa.getService_max_people());
                    statement.setInt(5, villa.getRent_type_id());
                    statement.setString(6, villa.getRoom_standard());
                    statement.setString(7, villa.getDescription_other_convenience());
                    statement.setDouble(8, villa.getPool_area());
                    statement.setInt(9, villa.getNumber_of_floors());
                    statement.setInt(10, villa.getId());
                    break;
                case 2:
                    House house = (House) facility;
                    statement = connection.prepareStatement(UPDATE_HOUSE);
                    statement.setString(1, house.getService_name());
                    statement.setInt(2, house.getService_area());
                    statement.setDouble(3, house.getService_cost());
                    statement.setInt(4, house.getService_max_people());
                    statement.setInt(5, house.getRent_type_id());
                    statement.setString(6, house.getRoom_standard());
                    statement.setString(7, house.getDescription_other_convenience());
                    statement.setInt(8, house.getNumber_of_floors());
                    statement.setInt(9, house.getId());
                    break;
                case 3:
                    Room room = (Room) facility;
                    statement = connection.prepareStatement(UPDATE_ROOM);
                    statement.setString(1, room.getService_name());
                    statement.setInt(2, room.getService_area());
                    statement.setDouble(3, room.getService_cost());
                    statement.setInt(4, room.getService_max_people());
                    statement.setInt(5, room.getRent_type_id());
                    statement.setInt(6, room.getId());
                    break;
            }
            statement.executeUpdate();
            System.out.println(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
