package com.goat.controller;


import com.goat.bean.User;
import com.goat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    public UserMapper userMapper;

    //    http://localhost:8444/test/test1
    @RequestMapping("/test1")
    public void test1() throws InterruptedException {
        User user = userMapper.selectById(2);
        // sos Thread.sleep(10000); 不会阻塞其他的请求。
        Thread.sleep(10000); // 先从数据库取出记录后   进行线程睡眠  让 test2 去修改
        user.setName("111111");
        int count =  userMapper.updateById(user);
        if(count>0){
            System.out.println(count + "---调用test11111111111111111111");
        }else {
            System.out.println("本次操作无效！");
        }
    }

    //    http://localhost:8444/test/test2
    @RequestMapping("/test2")
    public void test2(){
        User user = userMapper.selectById(2);
        user.setName("222222");
        int count =  userMapper.updateById(user);
        if(count>0){
            System.out.println(count + "调用test222222222222222222222");
        }else {
            System.out.println("本次操作无效！");
        }
    }
}
