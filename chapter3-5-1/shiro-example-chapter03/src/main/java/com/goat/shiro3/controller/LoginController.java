package com.goat.shiro3.controller;


import com.goat.shiro3.bean.User;
import com.goat.shiro3.config.MyShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(ModelMap map){  // ModelMap 也是一种渲染方式
        map.addAttribute("hello", "hello123");
        map.addAttribute("nani", "nani111");
        return "login";
    }

    @RequestMapping("/403")
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","没有授权哦");
        return "403";
    }
    //    http://localhost:8353/login
    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    //   http://localhost:8353/test3
    @RequestMapping("/doLogin")
    public String doLogin(String username , String password, Model model,boolean rememberMe){

        Subject subject = SecurityUtils.getSubject(); // 1. 获取 Subject
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);  // 2. 封装 用户输入的账号和密码
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
        // 3. 执行登录方法   如果没有抛出异常,就表示用户名和密码是匹配的,表示登录成功
        try {
            subject.login(token); //  跳到 doGetAuthenticationInfo 函数 去认证
            User user=(User) subject.getPrincipal();
//            Session session = subject.getSession(); // 这里为啥 使用这两句代码  就总是报错呢？
//            session.setAttribute("user", user);
            model.addAttribute("user",user);
//            return "redirect:/index"; //sos 这里不能使用 redirect: 否则 前端无法接收到  user 数据！！！
            return "/index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg",e.getMessage());
            return "login";
        }catch(Exception e) {
            //登录失败从request中获取shiro处理的异常信息 shiroLoginFailure:就是shiro异常类的全类名
            model.addAttribute("msg",e.getMessage());
            //返回登录页面
            return "login";
        }
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    //   http://localhost:8353/clear
    @RequestMapping("/clear")
    @ResponseBody
    public void clear(){
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        MyShiroRealm shiroRealm = (MyShiroRealm) securityManager.getRealms().iterator().next();
        shiroRealm.clearAllCache();//清除权限 相关的缓存
    }
}
