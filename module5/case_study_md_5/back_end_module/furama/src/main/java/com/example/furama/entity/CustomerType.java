package com.example.furama.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;
    private String customerType;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Customer> customers = new LinkedHashSet<>();

}
