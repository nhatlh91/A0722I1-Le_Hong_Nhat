package com.example.librarymgmt.repository;

import com.example.librarymgmt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByBookNameContains(String bookName);
}
