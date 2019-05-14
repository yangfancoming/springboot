package com.goat.service;

import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2018/9/26.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/26---15:32
 */
@Service
public class HelloService {

    public String sayHiService1(){
        System.out.println("sayHiService1"); // doit http://localhost:8341/hello1 请求  为啥执行不到这里？
        return "HelloService...........1";
    }

    public String sayHiService2(){
        System.out.println("sayHiService2");
       if (true){
           throw  new RuntimeException("123");
       }
        return "HelloService...........2";
    }
}
