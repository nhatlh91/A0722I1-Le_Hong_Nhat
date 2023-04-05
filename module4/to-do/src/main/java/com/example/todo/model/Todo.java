package com.example.todo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String detail;
}
