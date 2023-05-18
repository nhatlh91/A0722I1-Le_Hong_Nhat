package com.example.furama.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service<T> {
    Page<T> findAll(Pageable pageable);
    T save(T t);
    Optional<T> findById(Long id);
    void deleteById(Long id);
}
