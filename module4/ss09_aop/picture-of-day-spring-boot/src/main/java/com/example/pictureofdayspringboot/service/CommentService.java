package com.example.pictureofdayspringboot.service;

import com.example.pictureofdayspringboot.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface CommentService {
    Page<Comment> findAll(Pageable pageable);
    Page<Comment> findAllByDate(Pageable pageable, Date date);
    Page<Comment> findAllByCommentContains(Pageable pageable, String keyword);
    Comment findById(Long id);
    Comment save(Comment comment);
    void deleteById(Long id);
    void deleteAllById(Long[] ids);

}
