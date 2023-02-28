package com.example.baithi.models;

import java.sql.Date;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private String color;
    private String desc;
    private int category_id;

    public Product() {
    }

    public Product(String name, int price, int quantity, String color, String desc, int category_id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.desc = desc;
        this.category_id = category_id;
    }

    public Product(int id, String name, int price, int quantity, String color, String desc, int category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.desc = desc;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getDesc() {
        return desc;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public int compareTo(Product o) {
        return this.id - o.id;
    }
}
