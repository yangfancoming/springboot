package com.goat.hsqldb.controller;

import com.goat.hsqldb.dao.DemoDao;
import com.goat.hsqldb.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/7/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/4---18:34
 */

@RestController
public class DemoController {

    @Autowired
    private DemoDao demoDao;
    //  http://localhost:8466/save
    @RequestMapping("save")
    public String save(){
        List<Demo> list = new ArrayList<>(10);
        list.add(new Demo("张三",20));
        list.add(new Demo("李四",30));
        demoDao.saveAll(list);
        return "ok";
    }

    //  http://localhost:8466/find
    @RequestMapping("find")
    public List<Demo> find(){
        return (List<Demo>) demoDao.findAll();
    }

    //  http://localhost:8466/findByName
    @RequestMapping("findByName")
    public Demo findByName(){
        return demoDao.findByName("张三");
    }
}

