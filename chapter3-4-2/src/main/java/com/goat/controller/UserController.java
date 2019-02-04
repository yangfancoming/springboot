package com.goat.controller;


import com.goat.annotation.Log;
import com.goat.constant.BusinessType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    // 测试地址：    http://localhost:8342/api/user/save
    @Log(title = "用户管理", action = BusinessType.INSERT)
    @GetMapping("/save")
    public Boolean save(){
        return false;
    }

    // 测试地址：    http://localhost:8342/api/user/update
    @Log(title = "用户管理", action = BusinessType.UPDATE)
    @GetMapping("/update")
    public Boolean update(){
        return false;
    }

    // 测试地址：    http://localhost:8342/api/user/remove
    @Log(title = "用户管理", action = BusinessType.DELETE)
    @GetMapping("/remove")
    public Boolean remove(){
        return false;
    }

}
