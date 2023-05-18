package com.example.furama.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private Date customerDOB;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

}
