package com.example.casestudy.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Data
@Entity
public class Facility{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên không thể để trống")
    private String name;
    @Min(value = 50, message = "Diện tích sử dụng không thể thấp hơn 50m2")
    private double area;
    @Min(value = 0, message = "Giá tiền không thể là số âm")
    private int cost;
    @Min(value = 1, message = "Ít nhất 1 người")
    @Max(value = 10, message = "Nhiều nhất là 10 người")
    private int maxPeople;
    @ManyToOne
    @JoinColumn(name = "rentTypeId", referencedColumnName = "rentTypeId")
    private RentType rentType;
    private String roomStandard;
    private String otherConvenience;
    private double poolArea;
    private int numberOfFloor;
    private String additionalServiceId;
    private String facilityType;
    private Date dateOfModified;
}
