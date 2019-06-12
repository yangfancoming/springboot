package com.goat.doit.select2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/select2")
public class Select2Controller {


    @GetMapping("/list")
    public String success(){ //
        return "select2/demo01";
    }

}
