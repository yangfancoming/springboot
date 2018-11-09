package com.goat.controller;


import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired IEmpService iEmpService;

//    http://localhost:8441/hello/hellola
    @RequestMapping("/hellola")
    public Map hellola(){
        Map maps = iEmpService.findById(12);
        System.out.println(maps);
        return maps;
    }

}
