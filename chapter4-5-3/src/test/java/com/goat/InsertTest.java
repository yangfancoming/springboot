package com.goat;


import com.goat.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest extends CommonTest {


    // 插入时 指定了 id 主键 所以  遇到重复的id时 会忽略插入操作
    @Test
    public void save1() {
        repository.save(new User("1", "didi"));
        repository.save(new User("2", "mama"));
        repository.save(new User("3", "kaka"));
        List<User> users = repository.findAll();
        System.out.println(users);
    }


    // 插入时 没有指定 id 主键 所以 可以无限插入
    @Test
    public void save2() {
        repository.save(new User("didi"));
        repository.save(new User("mama"));
        repository.save(new User("kaka"));
        List<User> users = repository.findAll();
        System.out.println(users);
    }
}

