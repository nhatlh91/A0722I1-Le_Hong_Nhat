package com.example.product_management;

public class Product {
    private int id;
    private String name;
    private double price;
    private String desc;
    private String manufacturer;

    public Product() {
    }

    public Product(int id, String name, double price, String desc, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + desc + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
