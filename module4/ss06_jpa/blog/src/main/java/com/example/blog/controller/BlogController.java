package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class BlogController {
    @Autowired
    IBlogService service;

    @GetMapping("")
    public String showList(Model model){
        List<Blog> blogs = new ArrayList<>(service.findAll());
        model.addAttribute("blogs",blogs);
        return "/index";
    }

    @GetMapping("create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog){
        if (blog.getSummary()==null) {
            blog.setSummary(blog.getContent().substring(0, 20) + "...");
        }
        service.create(blog);
        return "redirect:";
    }

    @GetMapping("/{id}/detail")
    public String showCreate(@PathVariable("id") int id, Model model){
        Blog blog = service.findById(id);
        model.addAttribute("blog",blog);
        return "/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable("id") int id, Model model){
        Blog blog = service.findById(id);
        model.addAttribute("blog", blog);
        return "/edit";
    }

    @PostMapping("save")
    public String update(@ModelAttribute("blog") Blog blog){
        if (blog.getSummary().equals("")) {
            blog.setSummary(blog.getContent().substring(0, 20) + "...");
        }
        service.update(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/";
    }
}
