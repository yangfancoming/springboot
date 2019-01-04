package com.goat.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.dao.UserMapper;
import com.goat.entity.User;


//@Service(version = "1.0.0", timeout = 60000)
@Service
public class TestServiceImpl extends ServiceImpl<UserMapper, User> implements ITestService {


    // doit  @Transactional 事务回滚测试
    @Override

    public User sayHello(Integer id) {
        System.out.println("进入Dubbo 远程调用。。。。。。");
        return baseMapper.selectById(id);
    }


}