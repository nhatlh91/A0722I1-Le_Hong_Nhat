package com.example.pictureofdayspringboot.controller;

import com.example.pictureofdayspringboot.model.Comment;
import com.example.pictureofdayspringboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pictures")
public class CommentRestController {
    private CommentService commentService;

    @Autowired
    CommentRestController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping()
    public ResponseEntity<List<Comment>> showListOfComment(){
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> showListOfComment(@PathVariable("id")Long id){
        Comment comment = commentService.findById(id);
        if(comment==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Comment> addNewComment(@RequestBody Comment comment){
        comment.setId(null);
        return new ResponseEntity<>(commentService.save(comment),HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment){
        if(commentService.findById(comment.getId())==null){
            return new ResponseEntity<>(comment,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commentService.save(comment),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        Comment comment = commentService.findById(id);
        if(comment==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            commentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
