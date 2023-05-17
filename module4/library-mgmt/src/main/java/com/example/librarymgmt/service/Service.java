package com.example.librarymgmt.service;

import org.springframework.data.domain.Page;

import java.util.List;

public interface Service<T> {
    T findById(Long id);
    T save(T t);
    void delete(Long id);
}
