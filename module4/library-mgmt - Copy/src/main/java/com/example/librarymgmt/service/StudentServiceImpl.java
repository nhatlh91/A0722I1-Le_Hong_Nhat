package com.example.librarymgmt.service;


import com.example.librarymgmt.entity.Book;
import com.example.librarymgmt.entity.Student;
import com.example.librarymgmt.repository.BookRepository;
import com.example.librarymgmt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class StudentServiceImpl implements Service<Student>{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByStudentName(String studentName){
        return studentRepository.findAllByStudentNameContains(studentName);
    }
}

