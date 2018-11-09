package com.goat;


import com.goat.dao.BaseDao;
import com.goat.model.Emp;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired private ApplicationContext ac;
    @Autowired private BaseDao baseDao;
    @Autowired private SqlSessionFactory sqlSessionFactory;
    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }
    @Test
    public void sqlSessionFactory() {
        // 获取 sqlSession 他 能够执行 已经映射的sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // P1 sql的唯一标识   P2 执行sql要用的参数
        Map map = sqlSession.selectOne("findMapById",7369);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void findMapById() {
        Map map = baseDao.findMapById(7369);
        System.out.println(map);
    }
    @Test
    public void findObjectById() {
        Emp map = baseDao.findObjectById(7369);
        System.out.println(map);
    }

    @Test
    public void saveMap() {
        Map map = new HashMap();
        map.put("EMPNO",33);
        map.put("ENAME",44);
        int temp = baseDao.saveMap(map);
        System.out.println(temp);
    }
    @Test
    public void saveObject() {
        Emp emp = new Emp();
        emp.setEMPNO(55);
        emp.setENAME("66");
        int temp = baseDao.saveObject(emp);
        System.out.println(temp);
    }
    @Test
    public void deleteById() {
        int temp = baseDao.deleteById(55);
        System.out.println(temp);
    }
    @Test
    public void updateMapById() {
        Map map = new HashMap();
        map.put("ENAME","fuck");
        map.put("id",33);
        int temp = baseDao.updateMapById(map);
        System.out.println(temp);
    }

    @Test
    public void updateObjectById() {
        Emp emp = new Emp();
        emp.setEMPNO(33);
        emp.setENAME("shit");
        int temp = baseDao.updateObjectById(emp);
        System.out.println(temp);
    }
}
