package com.example.login.controller;

import com.example.login.model.User;
import com.example.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserService userService;


    @GetMapping("login")
    public String index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        System.out.println(setUser);
        if(setUser.equals("")) {
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("dologin")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        // Kiểm tra username và password có trùng khớp với CSDL hay không.
        if (userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) == null) {
            model.addAttribute("message", "Đăng nhập thất bại, xin thử lại");
        } else {
            System.out.println(setUser);
            setUser = user.getUsername();
            //Tạo cookie và gắn vào HttpResponse
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            //Set attibute cho session
            session.setAttribute("username", user.getUsername());
            return "redirect:/success";
        }
        return "login";
    }

    @GetMapping("success")
    public String showSuccessPage(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null || username.equals("")) {
            return "redirect:/login";
        } else {
            model.addAttribute("username", username);
            return "success";
        }
    }

    @GetMapping("logout")
    public String doLogout(HttpSession session, @RequestParam("username") String username) {
        session.invalidate();
        return "redirect:/login";
    }
}
