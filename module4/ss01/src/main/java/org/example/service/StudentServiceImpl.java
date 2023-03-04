package org.example.service;

import org.example.bean.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository repo;

    @Override
    public void insert(Student student) {
        repo.insert(student);
    }

    @Override
    public void update(Student student) {
        repo.update(student);
    }

    @Override
    public void delete(String id) {
        repo.delete(id);
    }

    @Override
    public Student findById(String id) {
        return repo.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repo.findAll();
    }
}
