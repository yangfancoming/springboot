package com.goat.controller;

import com.goat.service.IndexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
public class JspController {

    //    http://localhost:8280/hello
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello 8280 jsp ";
    }

    //    http://localhost:8280/hello1
    @GetMapping("/hello1")
    public String hello1(Model model)  {
        model.addAttribute("msg","haha jsp");
        return "index";
    }

    @Autowired
    IndexServiceImpl indexService;

    @GetMapping("/list")
    @ResponseBody
    public Map<String,Object> getList() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("data", indexService.findAll());
        return map;
    }
}
