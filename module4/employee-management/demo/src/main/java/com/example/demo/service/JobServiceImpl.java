package com.example.demo.service;

import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{
    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> findAllByHiringId(Long id) {
        return jobRepository.findAllByHiringId(id);
    }

    @Override
    public List<Job> findAllByHelperId(Long id) {
        return jobRepository.findAllByHelperId(id);
    }

    @Override
    public List<Job> findAllByLatitudeBetweenAndLongitudeBetween(double latitudeLowerBound, double latitudeUpperBound, double longitudeLowerBound, double longitudeUpperBound) {
        return jobRepository.findAllByLatitudeBetweenAndLongitudeBetweenAndActive(latitudeLowerBound, latitudeUpperBound, longitudeLowerBound, longitudeUpperBound, true);
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }
}
