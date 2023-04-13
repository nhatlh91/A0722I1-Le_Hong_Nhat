package com.example.pictureofdayspringboot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    @NotBlank(message = "Nội dung không được trống")
    private String comment;
    @NotBlank(message = "Tác giả không được trống")
    private String author;
    private Date date;
    private int liked;
}
