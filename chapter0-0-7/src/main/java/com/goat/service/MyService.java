package com.goat.service;

import com.goat.jar.MyInterface;
import com.goat.jar.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/2/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/14---11:29
 */
@Service
public class MyService implements MyInterface {

    public String sayHi(String name) {
        return "goat";
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1L,"22");
        User user2 = new User(1L,"22");
        User user3 = new User(1L,"22");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
