package com.goat.controller;


import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

   @Autowired IEmpService iEmpService;

    //    http://localhost:8511/hello/findById
    @RequestMapping("/findById")
    public void hellola(){
        iEmpService.findById("7369");
    }

    //    http://localhost:8511/hello/findAll
    @RequestMapping("/findAll")
    public void findAll(){
        iEmpService.findAll();
    }
}
