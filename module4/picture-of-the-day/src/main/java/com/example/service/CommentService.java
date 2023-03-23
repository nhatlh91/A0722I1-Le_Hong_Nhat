package com.example.service;

import com.example.model.Comment;
import com.example.repo.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public List<Comment> findAll() {
        return commentRepo.findAll();
    }
    public List<Comment> findByDate(Date date) {
        return commentRepo.findCommentsByDate(date);
    }

    public Comment findById(int id) {
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

    public void delete(int id) {
        commentRepo.deleteById(id);
    }

}
