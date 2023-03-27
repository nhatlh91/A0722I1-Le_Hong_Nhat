package com.example.formvalidation.repository;

import com.example.formvalidation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersById(Long id);
    List<User> findUsersByFirstName(String firstName);
    List<User> findUsersByLastName(String lastName);

}
