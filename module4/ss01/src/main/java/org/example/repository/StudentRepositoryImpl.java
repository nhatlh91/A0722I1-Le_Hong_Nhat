package org.example.repository;

import org.example.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static HashMap<String, Student> students;

    static {
        students = new HashMap<>();
        students.put("SV001", new Student("SV001", "Toàn", 22, "Đà Nẵng"));
        students.put("SV002", new Student("SV002", "Khánh", 21, "Quảng Nam"));
        students.put("SV003", new Student("SV003", "Vân", 20, "Đà Nẵng"));
        students.put("SV004", new Student("SV004", "Thảo", 19, "Huế"));
        students.put("SV005", new Student("SV005", "Hùng", 20, "Quảng Ngãi"));
    }


    @Override
    public void insert(Student student) {
        students.put(student.getId(),student);
    }

    @Override
    public void update(Student student) {
        students.put(student.getId(),student);
    }

    @Override
    public void delete(String id) {
        students.remove(id);
    }

    @Override
    public Student findById(String id) {
        return students.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }
}
