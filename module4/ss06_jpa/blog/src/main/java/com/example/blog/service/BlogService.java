package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository repo;

    @Override
    public void create(Blog blog) {
        repo.save(blog);
    }

    @Override
    public void update(Blog blog) {
        repo.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
