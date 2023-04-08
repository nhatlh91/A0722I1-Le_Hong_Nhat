package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Page<Book> findByTitle(String title, Pageable pageable);
    Book findById(Long id);
    Book save(Book book);
    void delete(Book book);
}
