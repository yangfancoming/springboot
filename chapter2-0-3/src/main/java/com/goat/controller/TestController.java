package com.goat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

@RestController
public class TestController {

    @RequestMapping("/random1")
    public ResponseEntity<Map> random1(HttpSession session){
        Map<String, Object> map = new HashMap<>();
        map.put("key", "random1");
        map.put("value", new Random().nextInt(100));
        session.setAttribute("map1", map);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping("/random2")
    public ResponseEntity<Map> random2(HttpSession session){
        Map<String, Object> map = new HashMap<>();
        map.put("key", "random2");
        map.put("value", new Random().nextInt(100));
        session.setAttribute("map2", map);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping("/error1")
    public Object error1(){
        return "error,无权限！";
    }
}
