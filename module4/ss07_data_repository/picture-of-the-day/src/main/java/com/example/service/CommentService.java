package com.example.service;

import com.example.model.Comment;
import com.example.repo.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public Page<Comment> findAll(Pageable pageable) {
        return commentRepo.findAll(pageable);
    }
    public Page<Comment> findByDate(Date date, Pageable pageable) {
        return commentRepo.findCommentsByDate(date, pageable);
    }

    public Comment findById(Long id) {
        return commentRepo.findById(id).orElse(null);
    }

    public List<Comment> getList() {
        Iterable<Comment> iterable = commentRepo.findAll();
        List<Comment> comments = new ArrayList<>();
        for (Comment c: iterable) {
            comments.add(c);
        }
        return comments;
    }

    public void update(Comment comment) {
        commentRepo.save(comment);
    }

    public void delete(Long id) {
        commentRepo.deleteById(id);
    }

}
