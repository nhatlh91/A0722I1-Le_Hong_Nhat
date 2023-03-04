package com.example.dictionary.controller;

import com.example.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService service;

    @GetMapping("dictionary/home")
    public String search(@RequestParam(required = false) String input, Model model){
        System.out.println(input);
        model.addAttribute("result", service.search(input));
        return "dictionary/home";
    }
}
