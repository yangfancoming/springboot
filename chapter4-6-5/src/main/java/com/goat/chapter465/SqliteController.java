package com.goat.chapter465;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/test")
public class SqliteController {


    @Autowired
    UserLoginDao userLoginDao;


    // 测试地址：  http://localhost:8465/test/test1

    @GetMapping("/test1")
	public UserLogin test1() {
        UserLogin temp = userLoginDao.findUserLoginByUserNameAndPassword("bharat0126","dbase123");
        return temp;
    }

    @GetMapping("/test2")
    public UserLogin test2() {
        Optional<UserLogin> byId = userLoginDao.findById(1);
        UserLogin userLogin = byId.get();
        return userLogin;
    }

    @GetMapping("/test3")
    public Iterable<UserLogin> test3() {
        Iterable<UserLogin> all = userLoginDao.findAll();
        return all;
    }

    @GetMapping("/test4")
    public void test4() {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail("111");
        userLogin.setFirstName("222");
        userLogin.setLastName("333");
        userLogin.setMobile("123");
        UserLogin save = userLoginDao.save(userLogin);
        System.out.println(save);
    }
}
