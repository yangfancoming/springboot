package com.goat.service;

import com.goat.entity.User;

public interface ITestService {

    // 此接口中的方法  并没有任何意思，纯粹是为了 服务的拆分
    User sayHello(Integer name);

    String testHystrix();
}
