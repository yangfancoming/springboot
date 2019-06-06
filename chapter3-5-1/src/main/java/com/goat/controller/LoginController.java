package com.goat.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(ModelMap map){  // ModelMap 也是一种渲染方式
        map.addAttribute("hello", "hello123");
        map.addAttribute("nani", "nani111");
        return "index";
    }

    @RequestMapping("/403")
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","没有授权哦");
        return "403";
    }
    //    http://localhost:8351/login
    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    // http://localhost:8351/hello/test3
    @RequestMapping("/doLogin")
    public String doLogin(String username , String password, Model model){

        Subject subject = SecurityUtils.getSubject(); // 1. 获取 Subject
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);  // 2. 封装 用户输入的账号和密码
        // 3. 执行登录方法   如果没有抛出异常,就表示用户名和密码是匹配的,表示登录成功
        try {
            subject.login(token); //  跳到 doGetAuthenticationInfo 函数 去认证
            return "redirect:/hello/success"; // 若没有异常则 登录成功
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

}
/*
*
AuthenticationException包含以下子类：

CredentitalsException  密码错误
IncorrectCredentialsException 不正确的凭证
ExpiredCredentialsException 凭证过期
AccountException 账号异常
ConcurrentAccessException 并发访问异常（多个用户同时登录时抛出）
UnknownAccountException 未知的账号
ExcessiveAttemptsException 认证次数超过限制
DisabledAccountException 禁用的账号
LockedAccountException 账号被锁定
UnsupportedTokenException 使用了不支持的Token

*
*
* */