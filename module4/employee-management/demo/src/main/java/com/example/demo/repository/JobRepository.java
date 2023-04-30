package com.example.demo.repository;

import com.example.demo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    List<Job> findAllByHiringId(Long id);
    List<Job> findAllByHelperId(Long id);
    List<Job> findAllByLatitudeBetweenAndLongitudeBetweenAndActive (double latitudeLowerBound, double latitudeUpperBound, double longitudeLowerBound, double longitudeUpperBound, boolean active);
}
