package com.example.formvalidation.controller;

import com.example.formvalidation.model.User;
import com.example.formvalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("")
    public String showRegisterForm(Model model){
        model.addAttribute("user",new User());
        return "form";
    }

    @PostMapping("create")
    public String createUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            service.create(user);
            model.addAttribute("user",user);
            return "result";
        }
    }
}
