package com.example.casestudy.controller;

import com.example.casestudy.model.Facility;
import com.example.casestudy.repository.RentTypeRepository;
import com.example.casestudy.service.FacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("/facilities/")
public class MainController {
    @Autowired
    private FacilityServiceImpl facilityService;
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @GetMapping("list")
    public String showMainPage(Model model, @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
                               @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("facilityType");
//        Sort sortBy = Sort.by("").descending().and(Sort.by("phoneNumber").ascending());
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortField).ascending());
        model.addAttribute("facilities", facilityService.findAll(pageable));
        return "facility/list";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("rentTypes", rentTypeRepository.findAll());
        return "facility/create";
    }

    @GetMapping("delete")
    public String deleteFacility(@RequestParam("id") Long id, RedirectAttributes rd) {
        facilityService.delete(id);
        String message = "Xoá thành công";
        rd.addFlashAttribute("message",message);
        return "redirect:/facilities/list";
    }

    @GetMapping("edit")
    public String showEditForm(@RequestParam("id") Long id, Model model) {
        model.addAttribute("rentTypes", rentTypeRepository.findAll());
        model.addAttribute("facility", facilityService.findById(id));
        return "facility/edit";
    }

    @PostMapping("create")
    public String createFacility(@Valid @ModelAttribute("facility") Facility facility, BindingResult bindingResult, RedirectAttributes rd, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("rentTypes", rentTypeRepository.findAll());
            return "facility/create";
        }
        facilityService.save(facility);
        String message = "Thêm mới thành công";
        rd.addFlashAttribute("message",message);
        return "redirect:/facilities/list";
    }

    @PostMapping("update")
    public String updateFacility(@Valid @ModelAttribute("facility") Facility facility, BindingResult bindingResult, RedirectAttributes rd, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("rentTypes", rentTypeRepository.findAll());
            return "facility/edit";
        }
        String message = "Cập nhật dịch vụ thành công";
        rd.addFlashAttribute("message",message);
        facilityService.save(facility);
        return "redirect:/facilities/list";
    }

    @GetMapping("search")
    public String showSortList(Model model, @RequestParam("keyword") Optional<String> keyword, @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
                               @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("facilityType");
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortField).ascending());
        Page<Facility> facilities = facilityService.multipleFieldSearch(keyword.orElse(""),pageable);
        model.addAttribute("facilities",facilities);
        return "facility/list";
    }
}
