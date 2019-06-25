package com.goat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 64274 on 2018/11/12.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/12---11:12
 */

@Controller
public class TestController {

    @Autowired
    private ApplicationContext ac;

    @GetMapping("/ac")
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    //    http://localhost:8203/random1
    @GetMapping("/random1")
    public String random1(String what){
        System.out.println("进入 random1 controller。。。。"+what);
        return "what";
    }

    //    http://localhost:8203/random2
    @GetMapping("/random2")
    @ResponseBody
    public ResponseEntity<Map> random2(HttpSession session){
        System.out.println("进入。。。。random2 controller。。。。");
        Map<String, Object> map = new HashMap<>();
        map.put("key", "random2");
        map.put("value", new Random().nextInt(100));
        session.setAttribute("map2", map);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    //    http://localhost:8203/random3
    @GetMapping("/random3")
    @ResponseBody
    public ResponseEntity<Map> random3(HttpSession session){
        System.out.println("进入。。。。random3 controller。。。。");
        Map<String, Object> map = new HashMap<>();
        map.put("key", "random3");
        map.put("value", new Random().nextInt(100));
        session.setAttribute("map3", map);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    //    http://localhost:8203/error1
    @GetMapping("/error1")
    @ResponseBody
    public Object error1(){
        return "error,无权限！";
    }

//    http://localhost:8203/test
    @GetMapping("/test")
    @ResponseBody
    public Object test(){
        return "test";
    }
}
