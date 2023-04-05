package com.example.productmng.controller;

import com.example.productmng.model.*;
import com.example.productmng.request.RequestForm;
import com.example.productmng.service.BrandService;
import com.example.productmng.service.CategoryService;
import com.example.productmng.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/")
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @GetMapping("list")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("create")
    public String showForm(Model model) {
        RequestForm requestForm = new RequestForm();
        model.addAttribute("requestForm", requestForm);
        return "create";
    }

    @PostMapping("create")
    public String save(@Validated @ModelAttribute("requestForm") RequestForm requestForm, BindingResult bindingResult, RedirectAttributes rd) {
        // Validate cac truong da nhap
        if(bindingResult.hasErrors()){
            return "create";
        }
        // Dung thong tin tu request form de khoi tao brand
        Brand brand = brandService.findByName(requestForm.getBrandName());
        if(brand==null){
            brand = new Brand();
            brand.setBrandName(requestForm.getBrandName());
            brand = brandService.save(brand);
        }

        // Dung thong tin tu request form de khoi tao category
        Category category = categoryService.findByName(requestForm.getCategoryName());
        if(category==null){
            category = new Category();
            category.setCategoryName(requestForm.getCategoryName());
            category = categoryService.save(category);
        }

        // Dung thong tin tren requestForm de khoi tao product
        Product product = new Product();
        product.setId(requestForm.getId());
        product.setName(requestForm.getProductName());
        product.setPrice(requestForm.getProductPrice());
        product.setQuantity(requestForm.getProductQuantity());
        product.setColor(requestForm.getProductColor());
        product.setDetail(requestForm.getProductDetail());
        product.setCategory(category);
        product.setBrand(brand);
        // Add product vao database
        productService.save(product);
        rd.addFlashAttribute("message","Đã cập nhật thành công");
        return "redirect:/list";
    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "detail";
    }

    @GetMapping("delete")
    public String showDetail(@RequestParam("id") Long id, RedirectAttributes rd) {
        productService.delete(id);
        rd.addFlashAttribute("message","Đã xoá thành công");
        return "redirect:/list";
    }

    @GetMapping("edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        Product product = productService.findById(id);
        RequestForm requestForm = new RequestForm(id,product.getName(), product.getPrice(), product.getQuantity(), product.getColor(),
                product.getDetail(), product.getCategory().getCategoryName(), product.getBrand().getBrandName());
        model.addAttribute("requestForm", requestForm);
        return "create";
    }

}
