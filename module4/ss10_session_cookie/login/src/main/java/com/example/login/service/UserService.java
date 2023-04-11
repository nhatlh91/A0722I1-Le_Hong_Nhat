package com.example.login.service;

import com.example.login.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByUsernameAndPassword(String username, String password);
    User save(User user);
    void delete(User user);
}
