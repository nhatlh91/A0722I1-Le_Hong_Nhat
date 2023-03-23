package com.example.controller;

import com.example.model.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@Controller
@RequestMapping("/pictures")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(Model model) {
        System.out.println("vao index");
        Date today = new Date(System.currentTimeMillis());
        List<Comment> comments = commentService.findByDate(today);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        return "index";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute(name = "newComment") Comment comment) {
        commentService.update(comment);
        return "redirect:/pictures/";
    }
}