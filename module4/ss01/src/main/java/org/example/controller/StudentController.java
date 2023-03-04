package org.example.controller;

import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/student/list")
    public String displayList(Model model) {
        model.addAttribute("students", service.findAll());
        return "student/list";}
}
