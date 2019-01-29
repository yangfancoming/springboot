package com.goat.test;

import com.goat.entity.User;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author itguang
 * @create 2017-12-17 13:14
 **/
@RestController
public class GetTest {

    protected static final String HOST = "http://localhost:8273";

    RestTemplate restTemplate = new RestTemplate();

    //无参数的 get 请求 http://localhost:8273/test1
    @RequestMapping("test1")
    public List<User> test1() {
        List<User> list = restTemplate.getForObject(HOST + "/get/users", List.class);
        System.out.println(list.toString());
        return list;
    }
    //无参数的 get 请求 http://localhost:8273/test2
    @RequestMapping("test2")
    public List<User> test2() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(HOST + "/get/users", List.class);
        HttpHeaders headers = responseEntity.getHeaders();
        HttpStatus statusCode = responseEntity.getStatusCode();
        List<User> list = responseEntity.getBody();
        System.out.println(headers);
        System.out.println(statusCode);
        System.out.println(list);
        return list;
    }
//
    //有参数的 get 请求 http://localhost:8273/test3/1
    @RequestMapping("test3/{id}")
    public User test3(@PathVariable(name = "id") String id) {
        User user = restTemplate.getForObject(HOST + "/get/getById/{id}", User.class, id);
        return user;
    }
//
//    //有参数的 get 请求
//    @RequestMapping("get3/{id}")
//    public UserEntity getById3(@PathVariable(name = "id") String id) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("id",id);
//
//        UserEntity userEntity = restTemplate.getForObject("http://localhost/get/{id}", UserEntity.class, map);
//
//        return userEntity;
//    }
//
//    //post 请求,提交 UserEntity 对像
//
//    @RequestMapping("saveUser")
//    public String save(UserEntity userEntity) {
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/save", userEntity, String.class);
//        String body = responseEntity.getBody();
//
//        return body;
//
//    }
//
//   // 有参数的 postForEntity 请求
//    @RequestMapping("saveUserByType/{type}")
//    public String save2(UserEntity userEntity,@PathVariable("type")String type) {
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", userEntity, String.class, type);
//        String body = responseEntity.getBody();
//
//        return body;
//
//    }
//
//    // 有参数的 postForEntity 请求,使用map封装
//    @RequestMapping("saveUserByType2/{type}")
//    public String save3(UserEntity userEntity,@PathVariable("type")String type) {
//        HashMap<String, String> map = new HashMap<>();
//         map.put("type", type);
//
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", userEntity, String.class,map);
//        String body = responseEntity.getBody();
//
//        return body;
//
//    }
//

}
