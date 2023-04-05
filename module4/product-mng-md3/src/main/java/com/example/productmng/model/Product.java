package com.example.productmng.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String color;
    private String detail;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brandId", referencedColumnName = "brandId")
    private Brand brand;
}
