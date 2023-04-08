package com.example.librarymanagement.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Tên tác phẩm không thể trống")
    private String title;
    @NotBlank(message = "Tên tác giả không thể trống")
    private String author;
    @Min(value = 0,message = "Số lượng không thể âm")
    private int quantity;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    Set<Rent> rentSet;

    public void decreaseQuantity(){
        this.quantity--;
    }

    public void increaseQuantity(){
        this.quantity++;
    }
}
