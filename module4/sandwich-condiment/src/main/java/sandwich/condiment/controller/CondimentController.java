package sandwich.condiment.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CondimentController {

    public CondimentController() {

    }

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/save")
    public String getResult(@RequestParam("condiment") String[] condiments, Model model) {
        System.out.println(condiments);
        model.addAttribute("condiments",condiments);
        return "result";
    }

}