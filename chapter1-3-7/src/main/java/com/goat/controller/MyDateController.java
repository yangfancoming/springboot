package com.goat.controller;


import com.goat.model.MyDate;
import com.goat.model.MyTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/mydate")
public class MyDateController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    protected static final String HOST = "http://127.0.0.1:8136";

    @Autowired
    RestTemplate restTemplate;


    // http://localhost:8137/mydate/test1   正常数据返回  list.size > 0
    @RequestMapping("test1")
    public void test1() {

        List<MyDate> list = restTemplate.getForObject(HOST + "/mydate/test1", List.class);
        logger.debug(Thread.currentThread().getName(),list);

        ResponseEntity<List> listResponseEntity = restTemplate.postForEntity(HOST + "/mydate/test2", list, List.class);
        logger.debug(Thread.currentThread().getName(),listResponseEntity);
    }

    // http://localhost:8137/mydate/test2
    @RequestMapping("test2")
    public void test2() {

        List<MyDate> list = restTemplate.getForObject(HOST + "/mydate/test1", List.class);
        logger.debug(Thread.currentThread().getName(),list);

        ResponseEntity<List> listResponseEntity = restTemplate.postForEntity(HOST + "/mydate/test3", list, List.class);
        logger.debug(Thread.currentThread().getName(),listResponseEntity);
    }
}
