package com.example.furama;

import com.example.furama.entity.Customer;
import com.example.furama.service.CustomerServiceImpl;
import com.example.furama.service.CustomerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerTypeServiceImpl customerTypeService;

    @GetMapping("/list")
    public String showList(Model model, Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypeService.findAll(Pageable.unpaged()));
        return "customer/create";
    }

}
