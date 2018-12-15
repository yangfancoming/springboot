package com.goat.controller;

import com.goat.service.CreateLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/create")
public class CreateLicenseController {


    @Autowired
    CreateLicenseService createLicenseService;

    // 测试地址：    http://localhost:8263/fuck
    @RequestMapping("/test1")
    public String success(Map<String,String> map){
        createLicenseService.doCreateLicense();
        map.put("hello","fuck123123");
        return "success";
    }

    // 测试地址：    http://localhost:8263/fuck2
    @RequestMapping("/test2")
    public String index(ModelMap map) { //  ModelMap 也是一种渲染方式
        map.addAttribute("hello", "http://blog.didispace.com");
        return "success";
    }




}