package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User save(User user);
    User findById(Long id);
    void deleteById(Long id);
    List<User> findByLocation(double latitude, double longitude);
    Optional<User> findByUserNameAndPassword(String username, String password);

}
