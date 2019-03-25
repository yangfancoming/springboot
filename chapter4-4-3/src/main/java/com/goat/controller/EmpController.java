package com.goat.controller;


import com.goat.entity.Emp;
import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/emp")
public class EmpController {

   @Autowired IEmpService iEmpService;

//    http://localhost:8443/emp/test1
    @RequestMapping("/test1")
    public List<Emp> test1(){
        List<Emp> e = iEmpService.findListLastNameLike("E");
        return e;
    }

}
