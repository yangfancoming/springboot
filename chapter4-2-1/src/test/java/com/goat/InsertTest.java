package com.goat;


import com.goat.domain.Customer;
import com.goat.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest extends TestCommon {

    List<User> users = new ArrayList<>();

    public void init(){
        users.add(new User("AAA", 10));
        users.add(new User("BBB", 20));
        users.add(new User("CCC", 30));
        users.add(new User("DDD", 40));
        users.add(new User("EEE", 50));
        users.add(new User("FFF", 60));
        users.add(new User("GGG", 70));
        users.add(new User("HHH", 80));
        users.add(new User("III", 90));
        users.add(new User("JJJ", 100));
    }
    @Test
    public void customerRepository(){
        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));
    }

    // 单条 插入
    @Test
    public void save() {
        User user = new User("ABC",111);
        user = userRepository.save(user);
        System.out.println(user);
    }
    // 批量插入 方式一
    @Test
    public void test01() {
        init();
        List<User> temps = userRepository.saveAll(users);
        System.out.println(temps.size());
    }

    // 批量插入 方式二
    @Test
    public void saveAll() {
        init();
        userService.saveAll(users);
    }
}
