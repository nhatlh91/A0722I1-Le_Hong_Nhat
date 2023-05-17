package com.example.librarymgmt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private String bookAuthor;
    private String bookDesc;
    private int bookQty;

    @OneToMany(mappedBy = "book")
    private Set<Ticket> tickets = new LinkedHashSet<>();

    public void decreaseQty() {
        if (this.bookQty > 0) {
            this.bookQty -= 1;
        }
    }

    public void increaseQty() {
        this.bookQty += 1;
    }
}
