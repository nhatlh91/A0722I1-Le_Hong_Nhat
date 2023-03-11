package com.practice.controller;


import com.practice.model.Login;
import com.practice.model.User;
import com.practice.repo.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("user",  new User());
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login, Model model){
        User user = UserRepo.checkLogin(login);
        if(user == null){
            return "error";
        } else {
            model.addAttribute("user", user);
            return "user";
        }
    }
}
