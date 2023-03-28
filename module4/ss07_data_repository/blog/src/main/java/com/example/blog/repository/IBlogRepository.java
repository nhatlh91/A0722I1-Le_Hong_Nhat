package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByAuthor(String author, Pageable pageable);
    Page<Blog> findAllByTitleContaining(Optional<String> keyword, Pageable pageable);
}
