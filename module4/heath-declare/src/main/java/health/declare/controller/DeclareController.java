package health.declare.controller;

import health.declare.model.Declare;
import health.declare.repo.DeclareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class DeclareController {

    @Autowired
    private DeclareRepo repo;
    public String[] nationals = new String[]{"Việt Nam","Trung Quốc", "Hàn Quốc", "Mỹ", "Nhật Bản", "Thái Lan", "Lào", "Campuchia"};

    @GetMapping("home")
    public String getHome(Model model){
        Declare declare = new Declare();
        model.addAttribute("declare", declare);
        model.addAttribute("nationals", nationals);
        return "/home";
    }

    @PostMapping("save")
    public String save(@ModelAttribute(name = "declare") Declare declare, Model model, RedirectAttributes rd){
        repo.add(declare);
        System.out.println(declare);
        model.addAttribute("declare",declare);
//        rd.addFlashAttribute("nationals", nationals);
//        rd.addFlashAttribute("message","Khai báo thành công");
        return "/info";
    }
}
