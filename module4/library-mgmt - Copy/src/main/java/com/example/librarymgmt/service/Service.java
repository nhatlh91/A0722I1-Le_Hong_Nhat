package com.example.librarymgmt.service;

import java.util.List;

public interface Service<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T t);
    void delete(Long id);
}
