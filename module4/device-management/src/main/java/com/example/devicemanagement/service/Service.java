package com.example.devicemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface Service<T> {
    Page<T> findAll(Pageable pageable);
    List<T> search(String keyword);
    T findById(Long id);
    T save(T t);
    void delete(Long id);
}
