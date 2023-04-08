package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;


    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Page<Book> findByTitle(String title, Pageable pageable) {
        return bookRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(new Book());
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }
}
