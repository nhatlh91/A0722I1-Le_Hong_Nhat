package com.example.controller;

import com.example.model.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller
@RequestMapping("/pictures")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public String index(Model model, Pageable pageable) {
        System.out.println("vao index");
        Date today = new Date(System.currentTimeMillis());
        Page<Comment> comments = commentService.findByDate(today,pageable);
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        return "index";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute(name = "newComment") Comment comment) {
        commentService.update(comment);
        return "redirect:/pictures";
    }

    @GetMapping("/comment/{id}")
    public String increaseLike(@PathVariable("id")Long id, Model model, Pageable pageable) {
        Comment comment = commentService.findById(id);
        comment.setLiked(comment.getLiked()+1);
        commentService.update(comment);
        System.out.println("Cap nhat thanh cong");
        return "redirect:/pictures";
    }
}