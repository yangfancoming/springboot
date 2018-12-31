package com.goat;

import com.goat.bean.Mydate;
import com.goat.bean.User;
import com.goat.dao.MydateMapper;
import com.goat.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MydateMapper mydateMapper;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void test() {
        Mydate mydate = mydateMapper.selectById(1);
        Date mydate1 = mydate.getMydate(); // Mon Dec 10 00:00:00 CST 2018
        Timestamp mydatetime = mydate.getMydatetime(); // 2018-12-10 00:00:00.0
        Timestamp mytimestamp = mydate.getMytimestamp(); // 2018-12-10 12:41:13.0

        System.out.println(mydate1.getTime());
        System.out.println(mydatetime.getTime());
        System.out.println(mytimestamp.getTime());

        if(mydate1.getTime() == mydatetime.getTime()){ // true
            System.out.println("OK");
        }
        if(mydate1.getTime() == mytimestamp.getTime()){ // false
            System.out.println("OK");
        }
    }
}