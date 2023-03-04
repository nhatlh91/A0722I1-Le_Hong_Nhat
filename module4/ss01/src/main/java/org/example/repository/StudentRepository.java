package org.example.repository;

import org.example.bean.Student;

import java.util.List;

public interface StudentRepository {
    void insert(Student student);
    void update(Student student);
    void delete (String id);
    Student findById(String id);
    List<Student> findAll();
}
