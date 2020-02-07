package com.goat.test;

import com.goat.chapter001.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("post")
public class PostTest extends BaseTest{

    /**---------------------------postForEntity-----------------------------*/

    /**
     方法的第一参数表示要调用的服务的地址
     方法的第二个参数表示上传的参数
     方法的第三个参数表示返回的消息体的数据类型
    */
    //post 请求,提交 UserEntity 对像  http://localhost:8273/post/saveUser?username=itguang&password=123456&age=20&email=123@123.com
    @RequestMapping("saveUser")
    public String save(User user) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/save", user, String.class);
        String body = responseEntity.getBody();
        return body;
    }

    // 有参数的 postForEntity 请求
    @RequestMapping("saveUserByType/{type}")
    public String save2(User user,@PathVariable("type")String type) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", user, String.class, type);
        String body = responseEntity.getBody();
        return body;
    }

    // 有参数的 postForEntity 请求,使用map封装
    @RequestMapping("saveUserByType2/{type}")
    public String save3(User user,@PathVariable("type")String type) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", type);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", user, String.class,map);
        String body = responseEntity.getBody();
        return body;
    }


    /**---------------------------getForObject-----------------------------*/
    /**
     如果你只关注，返回的消息体，可以直接使用postForObject。用法和getForObject一致。
     */
    @RequestMapping("test1")
    public User test1(User user) {
        User temp = restTemplate.postForObject("http://localhost/save", user, User.class);
        return temp;
    }

}
