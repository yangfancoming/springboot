package com.goat.jvm.controller;

import com.goat.jvm.JavaHeapTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/4/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/9---15:36
 */

@RestController
public class TestController {

    // http://localhost:8850/test
    @GetMapping("test")
    public void test(){
        JavaHeapTest javaHeapTest = new JavaHeapTest(JavaHeapTest.OUTOFMEMORY);
        System.out.println(javaHeapTest.getOom().length());
    }

    // http://localhost:8850/test1
    @GetMapping("test1")
    public void test1(){

    }
}