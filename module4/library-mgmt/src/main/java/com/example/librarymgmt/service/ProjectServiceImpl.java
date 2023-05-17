package com.example.librarymgmt.service;

import com.example.librarymgmt.entity.Project;
import com.example.librarymgmt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements com.example.librarymgmt.service.Service<Project> {
    @Autowired
    private ProjectRepository projectRepository;

    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }
    public Page<Project> search(String keyword, Pageable pageable) {
        return projectRepository.findAllByProjectNameContains(keyword, pageable);
    }

    public boolean validateProjectCode(String projectCode){
        return(projectRepository.findByProjectCode(projectCode)==null);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
