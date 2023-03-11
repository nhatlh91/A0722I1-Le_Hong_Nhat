package email.config.controller;

import email.config.model.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ConfigController {
    public String[] languages = new String[]{"English","Vietnamese", "Japanese", "Chinese"};
    public int[] pages = new int[]{5, 10, 15, 25, 50, 100};

    @GetMapping("home")
    public String getHome(Model model){
        EmailConfig emailConfig = new EmailConfig();
        model.addAttribute("emailConfig", emailConfig);
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        return "/home";
    }

    @PostMapping("save")
    public String save(Model model, @ModelAttribute(name = "emailConfig") EmailConfig emailConfig, RedirectAttributes rd){
        System.out.println(emailConfig);
        model.addAttribute("emailConfig",emailConfig);
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        model.addAttribute("message","Settings have been saved");
        return "/home";
    }
}
