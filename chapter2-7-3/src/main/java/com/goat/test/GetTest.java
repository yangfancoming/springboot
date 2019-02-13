package com.goat.test;

import com.goat.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author itguang
 * @create 2017-12-17 13:14
 **/
@RestController
public class GetTest extends BaseTest {

    protected static final String HOST = "http://localhost:8273";


    /**---------------------------getForEntity-----------------------------*/

    /**
     getForEntity第一个参数为我要调用的服务的地址，这里我调用了服务提供者提供的/hello接口，注意这里是通过服务名调用而不是服务地址，如果写成服务地址就没法实现客户端负载均衡了。
     getForEntity第二个参数String.class表示我希望返回的body类型是 List

    */
    //无参数的 getForEntity   http://localhost:8273/test2
    @RequestMapping("test2")
    public List<User> test2() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(HOST + "/get/users", List.class);
        HttpHeaders headers = responseEntity.getHeaders();
        HttpStatus statusCode = responseEntity.getStatusCode();
        List<User> list = responseEntity.getBody();
        System.out.println(headers);
        System.out.println(statusCode);
        System.out.println(statusCode.value());
        System.out.println(list);
        return list;
    }

    //有参数的 getForEntity 请求 返回实体
    @RequestMapping("getForEntity1/{id}")
    public User getById2(@PathVariable(name = "id") String id) {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://localhost/get/{id}", User.class, id);
        User userEntity = responseEntity.getBody();
        return userEntity;
    }

    //有参数的 getForEntity 请求,使用map封装参数
    @RequestMapping("getForEntity2/{id}")
    public User getById4(@PathVariable(name = "id") String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id",id);
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://localhost/get/{id}", User.class, map);
        User userEntity = responseEntity.getBody();
        return userEntity;
    }

    /**
     getForEntity 可以获取Http请求的全部信息.
     但是,通常情况下我们并不想要Http请求的全部信息,只需要相应体即可.对于这种情况,RestTemplate提供了 getForObject() 方法用来只获取 响应体信息.
     getForObject 和 getForEntity 用法几乎相同,指示返回值返回的是 响应体,省去了我们 再去 getBody() .
    */

    /**---------------------------getForObject-----------------------------*/

    //无参数的 getForObject 请求 http://localhost:8273/test1  返回 list 实体
    @RequestMapping("test1")
    public List<User> test1() {
        List<User> list = restTemplate.getForObject(HOST + "/get/users", List.class);
        System.out.println(list.toString());
        return list;
    }

    //有参数的 getForObject 请求 http://localhost:8273/test3/1  返回 实体
    @RequestMapping("test3/{id}")
    public User test3(@PathVariable(name = "id") String id) {
        User user = restTemplate.getForObject(HOST + "/get/getById/{id}", User.class, id);
        return user;
    }


    //有参数的 get 请求  返回 map
    @RequestMapping("get3/{id}")
    public User getById3(@PathVariable(name = "id") String id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id",id);
        User userEntity = restTemplate.getForObject("http://localhost/get/{id}", User.class, map);
        return userEntity;
    }

}
