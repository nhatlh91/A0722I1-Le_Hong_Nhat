package org.example.service;

import org.example.bean.Student;

import java.util.List;

public interface StudentService {
    void insert(Student student);
    void update(Student student);
    void delete (String id);
    Student findById(String id);
    List<Student> findAll();
}
