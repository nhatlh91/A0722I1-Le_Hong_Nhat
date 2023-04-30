package com.example.devicemanagement.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String brand;
    @NotEmpty
    private String model;
    @NotEmpty
    private String color;
    @Column(name = "description", length = 5000)
    private String description;
    private int price;
    private Date purchasingDate;
    @Column(name = "status", length = 2000)
    @NotEmpty
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
