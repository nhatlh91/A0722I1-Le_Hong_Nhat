package com.example.librarymgmt.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String studentClass;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new LinkedHashSet<>();

}
