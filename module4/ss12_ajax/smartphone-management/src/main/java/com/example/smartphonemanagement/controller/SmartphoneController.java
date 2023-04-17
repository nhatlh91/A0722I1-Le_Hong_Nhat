package com.example.smartphonemanagement.controller;

import com.example.smartphonemanagement.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class SmartphoneController {
    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("smartphones", smartphoneService.findAll());
        return "/list";
    }
}
