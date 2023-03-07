package calculator.controller;

import calculator.bean.Calculator;
import calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public EmailController(){

    }

    @GetMapping("/")
    public String getIndex (){
        return "index";
    }

    @PostMapping("/validate")
    public String validate(@RequestParam("email") String email, Model model){
        boolean flag = email.matches(EMAIL_REGEX);
        System.out.println(email);
        System.out.println(flag);
        model.addAttribute("flag",flag);
        model.addAttribute("email",email);
        return "validate";
    }
}
