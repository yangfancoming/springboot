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
        return "HelloService...........1";
    }

    public String sayHiService2(){
        return "HelloService...........2";
    }
}
