package com.example.repo;

import com.example.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ICommentRepo extends PagingAndSortingRepository<Comment, Long> {
    Page<Comment> findAll(Pageable pageable);
    Page<Comment> findCommentsByDate(Date date, Pageable pageable);
}
