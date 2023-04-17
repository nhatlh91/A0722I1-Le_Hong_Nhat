package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model,@RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("dateOfCreate");
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).descending());
        Page<Blog> blogs = blogService.findAll(pageable);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("blogs",blogs);
        model.addAttribute("categories",categories);
        return "blog/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "blog/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("blog") Blog blog){
        if (blog.getTitle().equals("")) {
            blog.setTitle(blog.getContent().substring(0, 95) + "...");
        }
        blogService.create(blog);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String showCreate(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/detail";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Long id, Model model){
        Blog blog = blogService.findById(id);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categories);
        return "/blog/edit";
    }

    @PostMapping("/save")
    public String update(@ModelAttribute("blog") Blog blog){
        if (blog.getTitle().equals("")) {
            blog.setTitle(blog.getContent().substring(0, 95) + "...");
        }
        blogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        blogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String showCreate(@RequestParam("keyword") String keyword, Model model){
        List<Blog> blogs = blogService.findByTitle(keyword);
        model.addAttribute("blogs",blogs);
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        return "blog/index";
    }
}
