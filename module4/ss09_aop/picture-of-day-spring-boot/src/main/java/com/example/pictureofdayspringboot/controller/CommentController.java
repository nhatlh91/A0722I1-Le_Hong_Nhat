package com.example.pictureofdayspringboot.controller;

import com.example.pictureofdayspringboot.model.Comment;
import com.example.pictureofdayspringboot.service.CommentService;
import exception.CommentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@Controller
@RequestMapping("/pictures")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("")
    public String index(Model model, Pageable pageable) {
        Date today = new Date(System.currentTimeMillis());
        Page<Comment> comments = commentService.findAllByDate(pageable,today);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        return "index";
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute(name = "newComment") Comment comment, BindingResult bindingResult,Model model, Pageable pageable) {
        if(bindingResult.hasErrors()){
            Date today = new Date(System.currentTimeMillis());
            Page<Comment> comments = commentService.findAllByDate(pageable,today);
            model.addAttribute("comments", comments);
            return "index";
        }
        commentService.save(comment);
        return "redirect:/pictures";
    }

    @GetMapping("/comment/{id}")
    public String increaseLike(@PathVariable("id")Long id, Model model, Pageable pageable) {
        Comment comment = commentService.findById(id);
        comment.setLiked(comment.getLiked()+1);
        commentService.save(comment);
        return "redirect:/pictures";
    }

}
