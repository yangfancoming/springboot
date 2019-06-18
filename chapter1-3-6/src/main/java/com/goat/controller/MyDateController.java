package com.goat.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goat.model.MyDate;
import com.goat.repository.MyDateRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public void test2(@RequestBody String result) {
        List<MyDate> list = new Gson().fromJson(result, new TypeToken<List<MyDate>>() {}.getType());
        System.out.println(list);
    }


    @RequestMapping(method = RequestMethod.POST, value = "test3", produces = MediaType.APPLICATION_JSON_VALUE)
    public void test3(@RequestBody String jsonStr) throws IOException {
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, MyDate.class);
        List<MyDate> list = mapper.readValue(jsonStr, type);
        System.out.println(list);
    }

    /**
        sos  Could not extract response: no suitable HttpMessageConverter found for response type [interface java.util.List]
            是由于 被请求方的原因： filter、intercepter 等拦截了 就会 出现这样的错误！！！
            应该是被拦截之后  默认返回的数据 没办法解析，导致的！！！
    */


    //    http://localhost:8136/mydate/test3
    protected static final String HOST = "http://127.0.0.1:8137";
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("test3")
    public void test3() {
        List<MyDate> list = repository.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<MyDate>> requestEntity = new HttpEntity<>(list, headers);
        ResponseEntity<List> exchange = restTemplate.exchange(HOST + "/mydate/test3", HttpMethod.POST, requestEntity, List.class);
        List<MyDate> body = exchange.getBody();
        System.out.println(body);
    }

//    http://localhost:8136/mydate/test4
    @RequestMapping("test4")
    public void test4() {
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity<>("JSCX161209051",headers);
        ResponseEntity<List> exchange = restTemplate.exchange("http://192.168.172.138:8080/Feeding/getFeedingMain", HttpMethod.POST, httpEntity, List.class);
        List body = exchange.getBody();
        System.out.println(body);
    }
}

