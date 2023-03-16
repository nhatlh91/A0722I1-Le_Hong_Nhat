package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        Product product = new Product();
        model.addAttribute("product",product);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(name = "product") Product product,RedirectAttributes rd) {
        productService.update(product);
        rd.addFlashAttribute("message","Task completed");
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, RedirectAttributes rd ) {
        productService.delete(id);
        rd.addFlashAttribute("message","Task completed");
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") int id, Model model ) {
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "detail";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") int id, Model model ) {
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "edit";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model ) {
        List<Product> products = productService.search(keyword);
        model.addAttribute("products",products);
        return "index";
    }
}