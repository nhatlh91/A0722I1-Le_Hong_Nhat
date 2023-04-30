package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(10000)")
    private String description;
    private double latitude;
    private double longitude;
    private Long hiringId;
    private Long helperId;
    private boolean active;
}
