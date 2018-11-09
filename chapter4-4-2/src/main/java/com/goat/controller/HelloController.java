package com.goat.controller;

//import com.example.goat.service.HelloService;

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

//    http://localhost:8442/hello/hellola
    @RequestMapping("/hellola")
    public void hellola(){
        List<Map>maps = iEmpService.findById();
        System.out.println(maps);
    }

}
