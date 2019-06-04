package com.goat.fastjson.controller;

import com.alibaba.fastjson.JSON;
import com.goat.fastjson.entity.Select;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/select")
public class SelectController {

    private List<Select> list = new ArrayList<>();

    //    http://localhost:8222/select/test1
    @GetMapping("/test1")
    public String test1(){
        List<Select> init = init();
        String string = JSON.toJSONString(init);
        System.out.println(string);
        return string;
    }
    public List<Select> init(){
        list.add(new Select(1,"heihei"));
        list.add(new Select(2,"haha"));
        return list;
    }





}
