package calculator.controller;

import calculator.bean.Calculator;
import calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorService service;

//    @GetMapping("/cal/home")
//    public String displayList(Model model) {
//        model.addAttribute("calculator", service.add());
//        return "cal/home";}

    @GetMapping("/cal/home")
    public String controller (Model model, @RequestParam(required = false, name = "first") String first, @RequestParam(required = false, name = "operand") String operand, @RequestParam(required = false, name = "second") String second){
        Calculator calculator = null;
        if (first != null && second != null && operand != null) {
            calculator = new Calculator(Integer.parseInt(first), Integer.parseInt(second));
            switch (operand){
                case "1":
                    model.addAttribute("calculator", service.add(calculator));
                    break;
                case "2":
                    model.addAttribute("calculator", service.sub(calculator));
                    break;
                case "3":
                    model.addAttribute("calculator", service.mul(calculator));
                    break;
                case "4":
                    model.addAttribute("calculator", service.div(calculator));
                    break;
            }
        }
        return "cal/home";
    }
}
