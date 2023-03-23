package com.example.repo;

import com.example.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ICommentRepo extends PagingAndSortingRepository<Comment, Integer> {
    List<Comment> findAll();
    List<Comment> findCommentsByDate(Date date);
}
