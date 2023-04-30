package com.example.demo.service;

import com.example.demo.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    List<Job> findAllByHiringId(Long id);
    List<Job> findAllByHelperId(Long id);
    List<Job> findAllByLatitudeBetweenAndLongitudeBetween (double latitudeLowerBound, double latitudeUpperBound, double longitudeLowerBound, double longitudeUpperBound);
    Job save(Job job);
    Job findById(Long id);
    void deleteById(Long id);
}
