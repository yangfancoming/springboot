package com.goat.thymeleaf.controller;

import com.goat.thymeleaf.model.Select2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("form")
public class FormController {

    List<Select2> select2List = new ArrayList<>();

    public void init(){
        select2List.clear();
        select2List.add(new Select2(1,"1"));
        select2List.add(new Select2(2,"2"));
        select2List.add(new Select2(3,"3"));
    }

    //   http://localhost:8216/form/test1
    @RequestMapping("test1")
    public String test1(Model model, String name, String check) {
        System.out.println(name);
        System.out.println(check);
        init();
        model.addAttribute("provList",select2List);
        return "form";
    }


    //   http://localhost:8216/form/test2
    @RequestMapping("test2")
    public void test2(String email,String password,String check) {
        System.out.println(email);
        System.out.println(password);
        System.out.println(check);
    }

}
