package com.goat;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.goat.bean.User;
import com.goat.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        //-----------------  根据 ID 删除
        userMapper.deleteById(11);
    }

    @Test
    public void deleteByMap() { //-----------------  Map 封装条件删除 ==> key 必须为数据表列名
        Map<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("last_name", "fjigww");
        userMapper.deleteByMap(deleteMap);
    }

    @Test
    public void delete() {   //-----------------  条件删除
        userMapper.delete(new QueryWrapper<User>().like("last_name", "111"));
    }

    @Test
    public void deleteBatchIds() { //-----------------  多 ID 删除
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(10);
        userMapper.deleteBatchIds(list);
    }
}