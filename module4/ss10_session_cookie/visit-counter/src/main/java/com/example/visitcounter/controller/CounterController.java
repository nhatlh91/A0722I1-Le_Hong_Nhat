package com.example.visitcounter.controller;

import com.example.visitcounter.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("counter")
public class CounterController {

    @ModelAttribute("counter")
    public Counter setupCounter(){
        return new Counter();
    }

    @GetMapping("/")
    public String showHomepage(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "/index";
    }
}
