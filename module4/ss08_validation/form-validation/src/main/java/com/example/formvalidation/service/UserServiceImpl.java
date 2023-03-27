package com.example.formvalidation.service;

import com.example.formvalidation.model.User;
import com.example.formvalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findUsersById(id);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> searchByFirstName(String firstName) {
        return repository.findUsersByFirstName(firstName);
    }

    @Override
    public List<User> searchByLastName(String lastName) {
        return repository.findUsersByLastName(lastName);
    }
}
