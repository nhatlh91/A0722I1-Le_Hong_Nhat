package com.example.casestudy.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentTypeId;
    private String rentType;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "rentType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Facility> facilities;
}

