package com.goat.controller;


import com.goat.model.MyTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/get")
public class GetDemoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    protected static final String HOST = "http://127.0.0.1:8136";

    @Autowired
    RestTemplate restTemplate;




    // http://localhost:8137/get/test1   正常数据返回  list.size > 0
    @RequestMapping("test1")
    public void test1() {

        List<MyTable> list = restTemplate.getForObject(HOST + "/consumer/test1", List.class);
        logger.debug(Thread.currentThread().getName(),list);

        ResponseEntity<List> listResponseEntity = restTemplate.postForEntity(HOST + "/consumer/test2", list, List.class);
        logger.debug(Thread.currentThread().getName(),listResponseEntity);
    }

    // http://localhost:8137/get/test2
    @RequestMapping("test2")
    public void test2() {

        List<MyTable> list = restTemplate.getForObject(HOST + "/consumer/test1", List.class);
        logger.debug(Thread.currentThread().getName(),list);

        ResponseEntity<List> listResponseEntity = restTemplate.postForEntity(HOST + "/consumer/test3", list, List.class);
        logger.debug(Thread.currentThread().getName(),listResponseEntity);
    }
}
