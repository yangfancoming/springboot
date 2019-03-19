package com.goat.service;

import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2018/11/30.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/30---13:19
 */
// 这里没加  @service 注解哦
@Service
public class HelloService {

    public void hello(){
        System.out.println("test......hello bean ..............");
    }
}
