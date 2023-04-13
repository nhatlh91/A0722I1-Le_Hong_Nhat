package com.example.pictureofdayspringboot.service;

import com.example.pictureofdayspringboot.model.Comment;
import com.example.pictureofdayspringboot.repository.CommentRepository;
import exception.CommentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommentServiceImpl implements CommentService{
    private static Set<String> badWords = new HashSet<>();
    static {
        badWords.add("shit");
        badWords.add("fuck");
        badWords.add("kill");
        badWords.add("murder");
        badWords.add("hell");
    }

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> findAllByDate(Pageable pageable, Date date) {
        return commentRepository.findAllByDate(pageable, date);
    }

    @Override
    public Page<Comment> findAllByCommentContains(Pageable pageable, String keyword) {
        return commentRepository.findAllByCommentContains(pageable, keyword);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment comment) {
        String[] words = comment.getComment().split(" ");
        for (String word : words) {
            if (badWords.contains(word.toLowerCase())) {
                String message = "The comment include " + word + " is not accepted.";
                throw new CommentException(message, comment);
            }
        }
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteAllById(Long[] ids) {
        for(Long id: ids){
            commentRepository.deleteById(id);
        }
    }
}
