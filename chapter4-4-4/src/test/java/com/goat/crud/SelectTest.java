package com.goat.crud;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.goat.entity.User;
import com.goat.dao.UserMapper;
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
 * @date 2018年12月7日21:49:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() { // 通过主键ID 查询
        System.out.println(userMapper.selectById(2L)); // SELECT id,name,age,version FROM user WHERE id=?
    }
    @Test
    public void selectOne() { // 通过多列查询（多条件查询）
        QueryWrapper<User> eq = new QueryWrapper<User>()
                .like("name", "C") // name 字段模糊查询
                .eq("age", 30);    // age  字段精准查询
        User user = userMapper.selectOne(eq);
        System.out.println(user);
    }
    @Test
    public void selectList() {   //-----------------  条件查询
        QueryWrapper<User> eq = new QueryWrapper<User>()
                .like("name", "C") // name 字段模糊查询
                .eq("age", 30);    // age  字段精准查询
        List<User> selectList = userMapper.selectList(eq);
        System.out.println("selectList ==> " + selectList);
    }

    @Test
    public void selectBatchIds() { // 通过多个主键id 进行查询
        List<Integer> ids = new ArrayList<>(16);
        ids.add(4);
        ids.add(5);
        ids.add(6);
        List<User> users = userMapper.selectBatchIds(ids);
        System.out.println(users);
    }
    @Test
    public void selectByMap() { // Map 封装条件查询 ==> key 必须是数据表列名
        Map<String,Object> map = new HashMap<>();
        map.put("age",30);
        map.put("name","CCC");
        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }

    @Test
    public void selectMaps() { //  查询数据返回 Map集合
        QueryWrapper<User> eq = new QueryWrapper<User>()
                .like("name", "C") // name 字段模糊查询
                .eq("age", 30);    // age  字段精准查询
        List<Map<String, Object>> selectMaps = userMapper.selectMaps(eq);
        System.out.println("selectMaps ==> " + selectMaps);
    }

    @Test
    public void selectMapsPage() { //  返回分页的 Map集合
        QueryWrapper<User> eq =  new QueryWrapper<User>()
                .between("age", 2, 25)
                .in("gender", 0, 1)
                .orderByDesc("age");
        IPage<Map<String, Object>> selectMapsPage = userMapper.selectMapsPage(new Page<>(1,2),eq);
        System.out.println("selectMapsPage ==> " + selectMapsPage.getRecords());
    }
    /**
         * @Description: 分页查询
         * @author: 杨帆
         * @Param:   IPage ==> mybatis自带的分页查询条件
         * @Return:   wrapper ==> 实体对象封装操作类（条件构造器）
         * @Date:   2018/12/7
    */
    @Test
    public void selectPage() {
        QueryWrapper<User> eq = new QueryWrapper<User>()
                .between("age", 0, 100)
                .eq("version", 1);
        IPage<User> selectPag = userMapper.selectPage(new Page<>(1, 3),eq);
        System.out.println("selectPage ==> " + selectPag.getRecords());
    }
    @Test
    public void selectCount() {  //-----------------  查询总条数  SELECT COUNT(1) FROM user WHERE id = ?
        Integer temp = userMapper.selectCount(new QueryWrapper<User>().eq("id", 2));
        System.out.println(temp);
    }

    @Test
    public void selectObjs() {  //-----------------  返回查询结果的第一个字段   (数据表的第一个字段)
        List<Object> selectObjs = userMapper.selectObjs(new QueryWrapper<User>()
                .like("name", "fj")
                .eq("age", 0)
        );
        System.out.println("selectObjs ==> " + selectObjs);
    }
}