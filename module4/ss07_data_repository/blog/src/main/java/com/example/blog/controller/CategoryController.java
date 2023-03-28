package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "category/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("category") Category category){
        categoryService.create(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}/detail")
    public String showCreate(@PathVariable("id") Long id, Model model){
        Category category = categoryService.findById(id);
        Set<Blog> blogs = category.getBlogs();
        model.addAttribute("category",category);
        model.addAttribute("blogs",blogs);
        return "/category/detail";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/category";
    }
}
