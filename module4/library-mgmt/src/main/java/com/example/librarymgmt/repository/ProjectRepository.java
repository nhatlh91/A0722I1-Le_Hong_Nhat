package com.example.librarymgmt.repository;

import com.example.librarymgmt.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    Page<Project> findAll(Pageable pageable);
    Page<Project> findAllByProjectNameContains(String projectName, Pageable pageable);
    Project findByProjectCode(String projectCode);
}
