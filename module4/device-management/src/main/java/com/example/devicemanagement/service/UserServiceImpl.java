package com.example.devicemanagement.service;

import com.example.devicemanagement.entity.User;
import com.example.devicemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
@org.springframework.stereotype.Service
public class UserServiceImpl implements Service<User>{
    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> search(String keyword) {
        return userRepository.findAllByEnglishNameIgnoreCase(keyword);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
