package com.goat.service;

import com.goat.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/10---11:20
 */

@Service
public class TestService {

    List<User> users = new ArrayList<>(16);
//    public User(String id, String name, Integer age, String username, String password, Long code)
    public List<User> test(){
        users.add(new User("1","11",111,"goat","1",1L));
        users.add(new User("2","22",222,"LIKE","2",2L));
        if (users.size()>5){
            users.clear();
        }
        return users;
    }


}
