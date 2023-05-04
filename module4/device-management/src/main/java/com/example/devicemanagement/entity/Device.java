package com.example.devicemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Tên thương hiệu không được để trống")
    private String brand;
    @NotEmpty(message = "Mã sản phẩm không được để trống")
    private String model;
    @NotEmpty(message = "Màu sắc không được để trống")
    private String color;
    @Column(name = "description", length = 5000)
    private String description;
    @Min(value = 0, message = "Giá tiền không thể nhỏ hơn 0")
    private int price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchasingDate;
    @Column(name = "status", length = 2000)
    @NotEmpty(message = "Trạng thái không được để trống")
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
