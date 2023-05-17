package com.example.librarymgmt.service;


import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class BookServiceImpl implements Service<Book>{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByBookName(String bookName){
        return bookRepository.findAllByBookNameContains(bookName);
    }
}

