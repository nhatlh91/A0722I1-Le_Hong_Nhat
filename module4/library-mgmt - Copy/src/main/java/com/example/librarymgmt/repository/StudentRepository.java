package com.example.librarymgmt.repository;

import com.example.librarymgmt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByStudentNameContains(String studentName);
}
