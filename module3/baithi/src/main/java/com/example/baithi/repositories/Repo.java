package com.example.baithi.repositories;

import com.example.baithi.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repo implements IRepo {

    private static final String INSERT_PLACE = "INSERT INTO product(name,price,quantity,color,description,category_id) VALUES(?,?,?,?,?,?)";
    private static final String SEARCH = "SELECT * FROM product JOIN category USING(category_id) WHERE name LIKE ? OR price LIKE ? OR category_name LIKE ? OR color LIKE ? OR price LIKE ?";
    private static final String DELETE = "DELETE FROM product WHERE id = ?";
    private static final String LIST_ALL = "SELECT * FROM product";
    private static final String SELECT_BY_ID = "SELECT * FROM product WHERE id = ?";
    private static final String UPDATE_PRODUCT = "UPDATE product SET name = ? , price = ? , quantity = ? , color = ? , description = ? , category_id = ? WHERE id = ?";

    @Override
    public void create(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_PLACE);
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                statement.setInt(3, product.getQuantity());
                statement.setString(4, product.getColor());
                statement.setString(5, product.getDesc());
                statement.setInt(6, product.getCategory_id());
                statement.execute();
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
    public List<Product> read() {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(LIST_ALL);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    int price = Integer.parseInt(resultSet.getString("price"));
                    int quantity = Integer.parseInt(resultSet.getString("quantity"));
                    String color = resultSet.getString("color");
                    String desc = resultSet.getString("description");
                    int category_id = Integer.parseInt(resultSet.getString("category_id"));
                    products.add(new Product(id, name, price, quantity, color, desc, category_id));
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
        Collections.sort(products);
        return products;
    }

    @Override
    public Product detail(int id) {
        Product product = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int price = Integer.parseInt(resultSet.getString("price"));
                    int quantity = Integer.parseInt(resultSet.getString("quantity"));
                    String color = resultSet.getString("color");
                    String desc = resultSet.getString("description");
                    int category_id = Integer.parseInt(resultSet.getString("category_id"));
                    product = new Product(id, name, price, quantity, color, desc, category_id);
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
        return product;
    }

    @Override
    public void update(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_PRODUCT);
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                statement.setInt(3, product.getQuantity());
                statement.setString(4, product.getColor());
                statement.setString(5, product.getDesc());
                statement.setInt(6, product.getId());
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
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE);
                statement.setInt(1, id);
                statement.execute();
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
    public List<Product> search(String keyword) {
        keyword = "%" + keyword + "%";
        System.out.println("Pattern: " + keyword);
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH);
                statement.setString(1, keyword);
                statement.setString(2, keyword);
                statement.setString(3, keyword);
                statement.setString(4, keyword);
                statement.setString(5, keyword);
                resultSet = statement.executeQuery();
                System.out.println(statement);
                while (resultSet.next()) {
                    int id = Integer.parseInt(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    int price = Integer.parseInt(resultSet.getString("price"));
                    int quantity = Integer.parseInt(resultSet.getString("quantity"));
                    String color = resultSet.getString("color");
                    String desc = resultSet.getString("description");
                    int category_id = Integer.parseInt(resultSet.getString("category_id"));
                    products.add(new Product(id, name, price, quantity, color, desc, category_id));
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
        Collections.sort(products);
        return products;
    }
}
