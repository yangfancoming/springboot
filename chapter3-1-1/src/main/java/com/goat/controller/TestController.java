package com.goat.controller;

import com.goat.exception.MyException;
import com.goat.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class TestController {

    @GetMapping("/test1")
    public String test1() throws Exception {
        throw new Exception("Exception 异常");
    }

    @GetMapping("/test2")
    public String test2() throws MyException {
        throw new MyException("自定义异常");
    }

    @GetMapping("/test3")
    public Integer test3() {
        int i = 1/0;
        return i;
    }

    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        throw new UserNotExistException(id);
    }

}