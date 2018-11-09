package com.goat;


import com.goat.domain.p.User;
import com.goat.domain.p.UserDao;
import com.goat.domain.p.UserRepository;
import com.goat.domain.p.UserService;
import com.goat.domain.s.Message;
import com.goat.domain.s.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test3 {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;
    @Test
    public void save() {

        // 向 core1 数据库 插入 数据
        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));
        Assert.assertEquals(5, userRepository.findAll().size());


        // 向 core2 数据库 插入 数据
        messageRepository.save(new Message("o1", "aaaaaaaaaa"));
        messageRepository.save(new Message("o2", "bbbbbbbbbb"));
        messageRepository.save(new Message("o3", "cccccccccc"));
        Assert.assertEquals(3, messageRepository.findAll().size());
    }

    @Test
    public void delete() {
        userService.deleteUserById(1L);
    }


    @Test
    public void create() {
        userDao.create("test",111);
    }

}
