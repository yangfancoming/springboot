package com.goat.controller;

import com.goat.repository.CumDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 64274 on 2019/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/6---14:39
 */
@RestController
@RequestMapping("/demo")
public class CumDemoController {

    @Autowired
    CumDemoRepository cumDemoRepository;
    //  http://localhost:8421/demo/test1
    @GetMapping("/test1")
    public void test1(){
        List<Object[]> lists = cumDemoRepository.test();
        for (Object[] l: lists){
            System.out.println(Long.valueOf(l[0].toString()));
            System.out.println(Long.valueOf(l[1].toString()));
        }
    }
}
