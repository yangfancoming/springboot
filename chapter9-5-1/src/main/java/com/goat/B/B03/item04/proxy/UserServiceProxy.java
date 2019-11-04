package com.goat.B.B03.item04.proxy;

import com.goat.B.B03.item04.IUserservice;

/**
 * Created by 64274 on 2019/4/7.
 *
 * @ Description: 静态代理 技术
 * @ author  山羊来了
 * @ date 2019/4/7---11:29
 */
public class UserServiceProxy {

    private IUserservice userservice;

    public UserServiceProxy(IUserservice userservice) {
        this.userservice = userservice;
    }

    public void add(){
        System.out.println("静态代理  开始事务");
        userservice.add();
        System.out.println("静态代理  提交事务");
    }

}
