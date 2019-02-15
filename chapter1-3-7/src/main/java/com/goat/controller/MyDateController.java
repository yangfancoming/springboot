package com.goat.controller;


import com.goat.model.MyDate;
import com.goat.model.MyTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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

    // http://localhost:8137/mydate/test0
    @RequestMapping("test0")
    public void test0() {

        // 这次请求 返回后的结果 被 restTemplate  封装成了 LinkedHashMap
        List<MyDate> list = restTemplate.getForObject(HOST + "/mydate/test1", List.class);
        logger.debug(Thread.currentThread().getName(),list);

        // 这次请求 返回后的结果 被 restTemplate  转换成了 MyDate 实体类
        ParameterizedTypeReference<List<MyDate>> typeRef = new ParameterizedTypeReference<List<MyDate>>() { };
        /**
         *  在这步转换时  若报错
         Can not construct instance of java.sql.Timestamp from String value '01-18-2018 09:16:32': not a valid representation
         (error: Failed to parse Date value '01-18-2018 09:16:32': Can not parse date "01-18-2018 09:16:32":
         not compatible with any of standard forms ("yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"))
         那么 请求 实体类 对应 日期类型 属性上  加上注解    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") 即可解决
        */
        ResponseEntity<List<MyDate>> responseEntity = restTemplate.exchange(HOST + "/mydate/test1", HttpMethod.GET, null, typeRef);
        List<MyDate> myModelClasses = responseEntity.getBody();
        System.out.println(myModelClasses);
    }

    // http://localhost:8137/mydate/test1   正常数据返回  list.size > 0
    @RequestMapping("test1")
    public void test1() {

        // 从 生产者 那里 get 数据 并解析
        List<MyDate> list = restTemplate.getForObject(HOST + "/mydate/test1", List.class);
        logger.debug(Thread.currentThread().getName(),list);

        // 把 get 的数据 解析后  再 post 回去
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
