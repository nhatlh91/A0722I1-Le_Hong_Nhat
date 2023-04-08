package com.example.pictureofdayspringboot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    @NotBlank(message = "Khong duoc de trong comment")
    private String comment;
    @NotBlank(message = "Khong duoc de thong author")
    private String author;
    private Date date;
    private int liked;
}
