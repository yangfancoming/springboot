package com.goat.controller;


import com.goat.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("test2")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    //    http://localhost:8331/test2/test0
    @GetMapping("test0")
    public void test0() {
        transactionService.test0();
    }

    //    http://localhost:8331/test2/test1
    @GetMapping("test1")
    public void test1() {
        transactionService.test1();
    }

    //    http://localhost:8331/test2/test2
    @GetMapping("test2")
    public void test2() {
        transactionService.test2();
    }
    //    http://localhost:8331/test2/test3
    @GetMapping("test3")
    public void test3() {
        transactionService.test3();
    }
}
