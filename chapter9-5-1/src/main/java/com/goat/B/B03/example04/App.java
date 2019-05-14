package com.goat.B.B03.example04;

import com.goat.B.B03.example04.proxy.UserServiceProxy;
import org.junit.Test;

/**
 * Created by 64274 on 2019/4/7.
 *
 * @ Description: 静态代理 技术
 * @ author  山羊来了
 * @ date 2019/4/7---11:26
 */
public class App {


    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        userService.add();
    }

    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.add();
    }

}
