package com.goat.doit.thymeleaf;

import com.goat.doit.common.model.User;
import com.goat.doit.select.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    List<Account> list = new ArrayList<>();
    List<User> userList = new ArrayList<>();

    public List<Account> init1(){
        list.clear();
        list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
        list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
        list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
        return list;
    }

    public List<User> init2(){
        userList.clear();
        userList.add(new User("1", "yizhiwazi", "20170928"));
        userList.add(new User("2", "kumamon", "123456"));
        userList.add(new User("3", "admin", "admin"));
        return userList;
    }
        /*
    现象：User 对象中出现的 userId 属性 与 chapter0-0-1 中的 User 属性id 不一致！
    报错：Caused by: org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'id' cannot be found on object of type 'com.goat.bean.User' - maybe not public or not valid?
    原因：pom.xml 文件中 没有加入  sos <packaging>war</packaging>
    */

    @RequestMapping("/list")
    public String hello(ModelMap map)  { //  ModelMap 也是一种渲染方式
        map.addAttribute("hello", "ModelMap");
        map.addAttribute("info", "haha-info");
        map.addAttribute("accountList",init1());
        map.addAttribute("userList", init2());
        return "thymeleaf/demo01";
    }



    // 测试地址：    http://localhost:8263/test1
    @RequestMapping("/test1")
    @ResponseBody
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","123123");
        return "success";
    }

    @GetMapping("/user")
    public String hehe(Model model) {
        model.addAttribute("user", new User(UUID.randomUUID().toString(), "yizhiwazi", "20170928"));
        return "thymeleaf/user";
    }

}