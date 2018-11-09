package com.goat;


import com.goat.domain.p.User;
import com.goat.domain.p.UserRepository;
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


    @Test
    public void getAllUsers() {
        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));

        Assert.assertEquals(5, userRepository.findAll().size());

        messageRepository.save(new Message("o1", "aaaaaaaaaa"));
        messageRepository.save(new Message("o2", "bbbbbbbbbb"));
        messageRepository.save(new Message("o3", "cccccccccc"));

        Assert.assertEquals(3, messageRepository.findAll().size());
    }



}
