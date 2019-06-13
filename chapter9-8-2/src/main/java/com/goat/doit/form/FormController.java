package com.goat.doit.form;


import com.goat.doit.select.Select;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/form")
public class FormController {

    List<Select> select2List = new ArrayList<>();

    public List<Select> init(){
        select2List.clear();
        select2List.add(new Select(1,"1"));
        select2List.add(new Select(2,"2"));
        select2List.add(new Select(3,"3"));
        return select2List;
    }


    @GetMapping("/list")
    public String pageRoles(Model model) {
        List<Select> select2List = init();
        model.addAttribute("provList",select2List);
        return "form/form";
    }

}
