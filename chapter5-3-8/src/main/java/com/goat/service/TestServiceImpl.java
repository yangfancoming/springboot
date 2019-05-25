package com.goat.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.dao.UserMapper;
import com.goat.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;


//@Service(version = "1.0.0", timeout = 60000)
@Service // 对外暴露服务实现  暴露类中的所有方法！
public class TestServiceImpl extends ServiceImpl<UserMapper, User> implements ITestService {

    @Value("${server.port}")
    private String port;

    // doit  @Transactional 事务回滚测试
    @Override
    public User sayHello(Integer id) {
        System.out.println("进入Dubbo 远程调用。。。。。。" + port);
        return baseMapper.selectById(id);
    }

    @HystrixCommand // sos 如果找到该注解  就需要添加  hystrix-javanica 依赖
    @Override
    public String testHystrix() {
        System.out.println("进入Dubbo 远程调用。。。。。。" + port);
        throw new RuntimeException("我是熔断器的测试。。。。。");
    }

    @Override
    public String testTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "测试提供服务超时！";
    }

}