package com.example.formvalidation.service;

import com.example.formvalidation.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    List<User> findAll();
    User findById(Long id);
    void update(User user);
    void delete(Long id);
    List<User> searchByFirstName(String firstName);
    List<User> searchByLastName(String lastName);
}
