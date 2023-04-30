package com.example.casestudy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long additionalServiceId;
    private String additionalServiceName;
    private int unit;
    private int cost;
}
