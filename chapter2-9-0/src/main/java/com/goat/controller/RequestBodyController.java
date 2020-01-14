package com.goat.controller;

import com.goat.entity.Product;
import com.goat.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/1/14.
 *
 * @ Description: @RequestBody 注解学习
 * @ author  山羊来了
 * @ date 2020/1/14---11:41
 */
@RestController
@RequestMapping(value = "/test")
public class RequestBodyController {

    /**
     * @RequestBody: 请求内容为JSON  字符串
     *	  测试方法在：查找 public void requestBodyString() throws Exception
     * @param body
     */
    @RequestMapping("/requestBodyString")
    public Object requestBodyString(@RequestBody String body){
        return body;
    }


    /**
     * @RequestBody: 请求内容为JSON  javaBean  sos 该注解会自动将 Json串 封装到JavaBean中
     *	  测试方法在：查找 public void requestBodyBean() throws Exception
     * @param user
     */
    @RequestMapping("/requestBodyBean")
    public User requestBodyBean(@RequestBody User user){
        return user;
    }


    // 测试地址：    http://localhost:8290/test/error1
    @RequestMapping("/error1")
    public String error1(String name,Integer price,String category) {
        System.out.println(name + price + category);
        return "error1";
    }

    // 测试地址：    http://localhost:8290/test/error2
    @RequestMapping("/error2")
    public String error2(@RequestBody Product product) {
        System.out.println(product.getName() + product.getPrice() + product.getCategory());
        return "error2";
    }


    // 测试地址：    http://localhost:8290/test/error3
    @RequestMapping("/error3")
    public String error3(Product product) {
        System.out.println(product.getName() + product.getPrice() + product.getCategory());
        return "error2";
    }


}
