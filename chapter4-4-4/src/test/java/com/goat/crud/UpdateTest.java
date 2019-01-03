package com.goat.crud;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.goat.entity.User;
import com.goat.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void updateById() {  // 通过主键ID 修改
        User user = new User(2L,"wahaha");
        System.out.println(userMapper.updateById(user)); // UPDATE user SET name=? WHERE id=?
    }

    @Test
    public void update() {  //-----------------  条件更改
        User user = new User();
        user.setName("HAHAHA");
        user.setAge(30);
        userMapper.update(user, new UpdateWrapper<User>()
                .eq("name", "CCC"));
    }





}