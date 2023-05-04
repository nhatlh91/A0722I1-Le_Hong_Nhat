package com.example.devicemanagement.controller;

import com.example.devicemanagement.entity.*;
import com.example.devicemanagement.service.*;
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
@RequestMapping("/device")
public class DeviceController {
    private DeviceServiceImpl deviceService;
    private CategoryServiceImpl categoryService;
    private UserServiceImpl userService;

    @Autowired
    public DeviceController(DeviceServiceImpl deviceService, CategoryServiceImpl categoryService, UserServiceImpl userService){
        this.categoryService = categoryService;
        this.deviceService = deviceService;
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
        model.addAttribute("devices", deviceService.findAll(pageable));
        return "/device/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model, Pageable pageable){
        model.addAttribute("device", new Device());
        model.addAttribute("categories", categoryService.findAll(pageable));
        model.addAttribute("users", userService.findAll(pageable));
        return "/device/create";
    }

    @PostMapping("/create")
    public String addNewDevice(@Valid @ModelAttribute("device") Device device, BindingResult bindingResult, RedirectAttributes rd, Pageable pageable, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                String message = "Đã có lỗi trong quá trình xác minh dữ liệu, vui lòng kiểm tra lại thông tin đã nhập";
                model.addAttribute("message", message);
                model.addAttribute("categories", categoryService.findAll(pageable));
                model.addAttribute("users", userService.findAll(pageable));
                return "/device/create";
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex);
            device.setPurchasingDate(null);
        }
        Long id = deviceService.save(device).getId();
        String message = "Thêm mới thành công, sản phẩm có ID là: "+id;
        rd.addFlashAttribute("message", message);
        return "redirect:/device/list";
    }

    @GetMapping("/detail")
    public String showDetail(Model model, @RequestParam("id")Long id){
        model.addAttribute("device", deviceService.findById(id));
        return "/device/detail";
    }

    @GetMapping("/edit")
    public String showEditForm(Model model, Pageable pageable, @RequestParam("id")Long id){
        model.addAttribute("device", deviceService.findById(id));
        model.addAttribute("categories", categoryService.findAll(pageable));
        model.addAttribute("users", userService.findAll(pageable));
        return "/device/edit";
    }


    @PostMapping("/update")
    public String updateDeviceInfo(@Valid @ModelAttribute("device") Device device, BindingResult bindingResult, RedirectAttributes rd, Pageable pageable, Model model){
        if(bindingResult.hasErrors()){
            String message = "Đã có lỗi trong quá trình xác minh dữ liệu, vui lòng kiểm tra lại thông tin đã nhập";
            model.addAttribute("message", message);
            model.addAttribute("categories", categoryService.findAll(pageable));
            model.addAttribute("users", userService.findAll(pageable));
            return "/device/edit";
        }
        Long id = deviceService.save(device).getId();
        String message = "Cập nhật thông tin cho thiết bị " + id + " thành công";
        rd.addFlashAttribute("message", message);
        return "redirect:/device/list";
    }

}
