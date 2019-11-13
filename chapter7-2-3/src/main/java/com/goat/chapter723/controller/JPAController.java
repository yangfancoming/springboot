package com.goat.chapter723.controller;


import com.goat.chapter723.entity.User;
import com.goat.chapter723.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("hello")
public class JPAController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 插入用户
     *   http://localhost:8723/hello/test1
    */
    @GetMapping("/test1")
    public User test1() {
        User test = new User();
        test.setId("1002");
        test.setUsername("test");
        test.setPassword("123123");
        test.setRemark("solr user index test!");
        User save = userRepository.save(test);
        System.out.println(save);
        return save;
    }

    /**
     * 查询所有用户
     *   http://localhost:8723/hello/test2
     */
    @GetMapping("/test2")
    public Iterable<User> test2() {
        Iterable<User> all = userRepository.findAll();
        return all;
    }


}
