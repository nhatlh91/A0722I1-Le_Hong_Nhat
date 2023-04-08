package com.example.librarymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentId;
    @Column(unique = true)
    private String rentCode;
    @NotBlank(message = "Tên người mượn mà để trống biết đâu đòi")
    private String name;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    public String generateCode(){
        int leftLimit = 65; // letter 'a'
        int rightLimit = 90; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        this.rentCode = buffer.toString();
        return this.rentCode;
    }
}
