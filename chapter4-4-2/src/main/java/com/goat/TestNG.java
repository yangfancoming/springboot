package com.goat;


import com.goat.dao.BaseDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Map;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class TestNG {

    @Autowired
    private ApplicationContext ac;

    @Autowired private BaseDao baseDao;

    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    // 这里可以正常返回查询结果
    @Test
    public void findById() {
        List<Map> maps = baseDao.findById("7369");
        System.out.println(maps);
    }

    @Test
    public void test() {

    }
}
