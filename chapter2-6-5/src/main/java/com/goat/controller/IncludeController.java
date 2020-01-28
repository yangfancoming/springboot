package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class IncludeController {

    // http://localhost:8265/test/include1
    @RequestMapping("/include1")
    public String demo1(Model model) {
        // doit  这里为啥报错  Template not found for name "includeTest.ftl".
        model.addAttribute("username", "goat");
        return "test/include";
    }


}
