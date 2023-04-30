package com.example.demo.controller;

import com.example.demo.entity.Job;
import com.example.demo.entity.User;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String showHomePage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("setUser");
        if (user == null) {
            return "redirect:login";
        }
        model.addAttribute("fullName",user.getFullName());
        return "index";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAll());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, RedirectAttributes rd) {
        userService.save(user);
        rd.addFlashAttribute("noti","Ghi danh thành công");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        User user = userService.findByUserNameAndPassword(username, password).orElse(null);
        if (user == null) {
            model.addAttribute("noti", "Tên đăng nhập hoặc mật khẩu trật lất");
            return "login";
        }
        session.setAttribute("setUser", user);
        return "redirect:/";
    }

    @GetMapping("/job")
    public String newJob(Model model, HttpSession session) {
        User user = (User) session.getAttribute("setUser");
        if (user == null) {
            return "redirect:login";
        }
        model.addAttribute("job", new Job());
        return "job-create";
    }

    @PostMapping("/job")
    public String saveJob(@ModelAttribute("job") Job job, HttpSession session, RedirectAttributes rd) {
        User user = (User) session.getAttribute("setUser");
        job.setHiringId(user.getId());
        job.setLatitude(user.getLatitude());
        job.setLongitude(user.getLongitude());
        job.setActive(true);
        jobService.save(job);
        rd.addFlashAttribute("noti","Niêm yết thành công");
        return "redirect:/";
    }

    @GetMapping("/job-finding")
    public String jobSearch(HttpSession session) {
        User user = (User) session.getAttribute("setUser");
        if (user == null) {
            return "redirect:login";
        }
        return "find-job";
    }

    @PostMapping("/job-finding")
    public String jobList(HttpSession session, @RequestParam(value = "radius", required = false) Double radius, Model model) {
        if (radius == null) {
            radius = 0.0;
        }
        User user = (User) session.getAttribute("setUser");
        double latitudeLowerBound = user.getLatitude() - radius;
        double latitudeUpperBound = user.getLatitude() + radius;
        double longitudeLowerBound = user.getLongitude() - radius;
        double longitudeUpperBound = user.getLongitude() + radius;
        List<Job> jobsNearby = jobService.findAllByLatitudeBetweenAndLongitudeBetween(latitudeLowerBound, latitudeUpperBound, longitudeLowerBound, longitudeUpperBound);
        model.addAttribute("jobs", jobsNearby);
        return "find-job";
    }

    @GetMapping("/accept")
    public String jobAssignment(HttpSession session, @RequestParam("id") Long jobId, Model model) {
        User user = (User) session.getAttribute("setUser");
        Job job = jobService.findById(jobId);
        job.setHelperId(user.getId());
        job.setActive(false);
        jobService.save(job);
        model.addAttribute("notification", "Các hạ đã nhận nhiệm vụ thành công, mau mau hoàn thành");
        return "find-job";
    }

    @GetMapping("/cancel")
    public String cancelMission(HttpSession session, @RequestParam("id") Long jobId, Model model) {
        User user = (User) session.getAttribute("setUser");
        Job job = jobService.findById(jobId);
        if(job.getHiringId().equals(user.getId())) {
            job.setActive(false);
            jobService.save(job);
            model.addAttribute("notification", "Quý khách đã thu hồi nhiệm vụ thành công");
        } else {
            model.addAttribute("notification", "Nhiệm vụ chỉ có thể được thu hồi bởi người giao phó");
        }
        return "find-job";
    }
}
