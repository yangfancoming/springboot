package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HelloController {

    // http://localhost:8265/test/demo1
    @RequestMapping("/demo1")
    public String demo1(Model model) {
        model.addAttribute("user", "goat");
        model.addAttribute("num", 0);
        model.addAttribute("mark", true);
        return "test/hello";
    }


}
