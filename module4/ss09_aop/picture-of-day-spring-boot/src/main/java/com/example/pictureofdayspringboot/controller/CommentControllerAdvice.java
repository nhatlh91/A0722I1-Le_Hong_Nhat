package com.example.pictureofdayspringboot.controller;

import exception.CommentException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(CommentException ex, Model model){
        String message = ex.getMessage();
        model.addAttribute("message",message);
        return "error";
    }
}
