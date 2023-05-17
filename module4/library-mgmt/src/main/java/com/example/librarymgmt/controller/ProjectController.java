package com.example.librarymgmt.controller;


import com.example.librarymgmt.entity.Company;
import com.example.librarymgmt.entity.Project;
import com.example.librarymgmt.service.CompanyServiceImpl;
import com.example.librarymgmt.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projects/")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectService;
    @Autowired
    private CompanyServiceImpl companyService;

    @GetMapping("list")
    public String showProjects(Model model, @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size,
                               @RequestParam("sort") Optional<String> sort){
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("announDate");
//        Sort sortBy = Sort.by("").descending().and(Sort.by("phoneNumber").ascending());
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by(sortField).ascending());
        model.addAttribute("projects", projectService.findAll(pageable));
        return "project/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        Project project = new Project();
        List<Company> companies = companyService.findAll();
        model.addAttribute("project", project);
        model.addAttribute("companies", companies);
        return "project/create";
    }

    @PostMapping("create")
    public String createForm(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("companies", companyService.findAll());
            return "project/create";
        }
        if(!projectService.validateProjectCode(project.getProjectCode())){
            String message = "Mã dự án đã có trong hồ sơ";
            model.addAttribute("companies", companyService.findAll());
            model.addAttribute("project", project);
            model.addAttribute("message", message);
            return "project/create";
        }
        project.setFee();
        projectService.save(project);
        return "redirect:/projects/list";
    }

    @GetMapping("detail")
    public String showDetail(@RequestParam("projectId") Long projectId, Model model) {
        Project project = projectService.findById(projectId);
        model.addAttribute("project", project);
        return "project/detail";
    }

    @GetMapping("search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model, Pageable pageable) {
        if(keyword==null){
            return "redirect:/projects/list";
        }
        Page<Project> projects = projectService.search(keyword,pageable);
        model.addAttribute("projects", projects);
        return "project/list";
    }
}
