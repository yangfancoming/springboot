package com.goat.controller;


import com.goat.bean.Emp;
import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired IEmpService iEmpService;

    //    http://localhost:8511/hello/findById
    @RequestMapping("/findById")
    public void hellola(){
        Map map = iEmpService.findById("7369");
        System.out.println(map);
    }

    //    http://localhost:8511/hello/findAll
    @RequestMapping("/findAll")
    public void findAll(){
        List<Emp>maps = iEmpService.findAll();
        System.out.println(maps);
    }
}
