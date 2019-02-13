package com.goat.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goat.model.MyDate;
import com.goat.model.MyTable;
import com.goat.repository.MyDateRepository;
import com.goat.repository.MyTableRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by 64274 on 2019/2/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/13---17:47
 */
@RestController
@RequestMapping("/mydate")
public class MyDateController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public MyDateRepository repository;


    // http://localhost:8136/mydate/test1   正常数据返回  list.size > 0
    @RequestMapping("test1")
    public List<MyDate> test1() {
        List<MyDate> list = repository.findAll();
        logger.debug(Thread.currentThread().getName(),list);
        return list;
    }

    /**  使用 谷歌 Gson  进行解析 会报错：
     java.lang.NumberFormatException: Invalid number: 20:1
     */

    @RequestMapping(method = RequestMethod.POST, value = "test2", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void test2(@RequestBody String result) {
        // 1. 将mes传来的Json数据 转成 list<T>
        List<MyDate> list = new Gson().fromJson(result, new TypeToken<List<MyDate>>() {}.getType());
        System.out.println(list);
    }

    @RequestMapping(method = RequestMethod.POST, value = "test3", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void test3(@RequestBody String jsonStr) throws IOException {
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, MyDate.class);
        List<MyDate> list = mapper.readValue(jsonStr, type);
        System.out.println(list);
    }

}

