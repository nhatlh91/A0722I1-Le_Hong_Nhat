package com.example.casestudy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Service<T> {
    Page<T> findAll(Pageable pageable);

    T findById(Long id);

    T save(T t);

    void delete(Long id);
    Page<T> search(String keyword, Pageable pageable);
}
