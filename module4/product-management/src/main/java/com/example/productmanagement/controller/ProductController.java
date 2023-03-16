package com.example.productmanagement.controller;

import com.example.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping("/")
    public String getList(Model model){
        model.addAttribute("products",service.findAll());
        return "list";
    }

}
