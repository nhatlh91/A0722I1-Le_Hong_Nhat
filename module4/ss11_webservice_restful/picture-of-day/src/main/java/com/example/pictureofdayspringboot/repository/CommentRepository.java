package com.example.pictureofdayspringboot.repository;

import com.example.pictureofdayspringboot.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Page<Comment> findAllByDate(Pageable pageable, Date date);
    Page<Comment> findAllByCommentContains(Pageable pageable, String keyword);
}
