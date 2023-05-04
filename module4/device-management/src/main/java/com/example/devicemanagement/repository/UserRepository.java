package com.example.devicemanagement.repository;

import com.example.devicemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByEnglishNameIgnoreCase(String keyword);
}
