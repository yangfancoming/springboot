package com.goat.controller;

import com.goat.constant.View;
import com.goat.exception.BadRequestException;
import com.goat.exception.MyException;
import com.goat.exception.NotFoundException;
import com.goat.exception.UserNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


@RestController
public class TestController {

    // 测试地址： http://localhost:8311/test1
    @GetMapping("/test1")
    public String test1() throws Exception {
        throw new Exception("Exception 异常");
    }
    // 测试地址： http://localhost:8311/test2
    @GetMapping("/test2")
    public String test2() throws MyException {
        throw new MyException("自定义异常");
    }
    // 测试地址： http://localhost:8311/test3
    @GetMapping("/test3")
    public Integer test3() {
        int i = 1/0;
        return i;
    }

    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        throw new UserNotExistException(id);
    }

    @RequestMapping("/test/{view}")
    public Object index(@PathVariable("view") String view) throws Exception {
        View v = View.getView(view);
        switch (v) {
            case sql:
                throw new SQLException("数据库异常！");
            case bad:
                throw new BadRequestException("失败的请求！");
            case zhyd:
                throw new MyException("这是一个自定义的异常！");
            case exception:
                return 1 / 0;
            default:
                throw new NotFoundException("页面未找到！");
        }
    }

}