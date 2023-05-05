package com.example.devicemanagement.controller;

import com.example.devicemanagement.entity.User;
import com.example.devicemanagement.service.CategoryServiceImpl;
import com.example.devicemanagement.service.DeviceServiceImpl;
import com.example.devicemanagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String showListOfDevice(Model model, @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size,
                                   @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("purchasingDate");
//        Sort sortBy = Sort.by("").descending().and(Sort.by("phoneNumber").ascending());
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortField).descending());
        model.addAttribute("user", userService.findAll(pageable));
        return "/user/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "/user/create";
    }

    @PostMapping("/create")
    public String addNewDevice(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes rd, Model model) {
        if (bindingResult.hasErrors()) {
            String message = "Đã có lỗi trong quá trình xác minh dữ liệu, vui lòng kiểm tra lại thông tin đã nhập";
            model.addAttribute("message", message);
            return "/user/create";
        }
        Long id = userService.save(user).getUserId();
        String message = "Thêm mới thành công, sản phẩm có ID là: " + id;
        rd.addFlashAttribute("message", message);
        return "redirect:/user/list";
    }

    @GetMapping("/detail")
    public String showDetail(Model model, @RequestParam("id") Long id) {
        model.addAttribute("device", userService.findById(id));
        return "/user/detail";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, @RequestParam("id") Long id) {
        model.addAttribute("device", userService.findById(id));
        return "/user/edit";
    }

    @PostMapping("/update")
    public String updateDeviceInfo(@Valid @ModelAttribute("device") User user, BindingResult bindingResult, RedirectAttributes rd, Model model) {
        if (bindingResult.hasErrors()) {
            String message = "Đã có lỗi trong quá trình xác minh dữ liệu, vui lòng kiểm tra lại thông tin đã nhập";
            model.addAttribute("message", message);
            return "/user/edit";
        }
        Long id = userService.save(user).getUserId();
        String message = "Cập nhật thông tin cho thiết bị " + id + " thành công";
        rd.addFlashAttribute("message", message);
        return "redirect:/user/list";
    }

}
