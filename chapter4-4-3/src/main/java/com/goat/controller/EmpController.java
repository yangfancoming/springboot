package com.goat.controller;


import com.goat.entity.Emp;
import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/emp")
public class EmpController {

   @Autowired IEmpService iEmpService;

//    http://localhost:8443/emp/test1
    @GetMapping("/test1")
    public List<Emp> test1(){
        List<Emp> e = iEmpService.findListLastNameLike("E");
        return e;
    }

    //    http://localhost:8443/emp/test2
    @GetMapping("/test2")
    public Map test2(){
        Map maps = iEmpService.findMapById(7369);
        return maps;
    }


    //    http://localhost:8443/emp/test3
    @GetMapping("/test3")
    public Map test3(){
        Map<Integer, Emp> e = iEmpService.findListLastNameLike2("E");
        return e;
    }

    //    http://localhost:8443/emp/test4
    @GetMapping("/test4")
    public Map test4(){
        Map maps = iEmpService.findMapById2(7369);
        return maps;
    }
}
