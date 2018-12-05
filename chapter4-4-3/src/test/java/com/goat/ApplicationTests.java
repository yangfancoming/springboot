package com.goat;


import com.goat.bean.Dept;
import com.goat.dao.EmpDao;
import com.goat.model.Emp;
import com.goat.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired private EmpDao empDao;
    @Autowired private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void before(){
        sqlSession = sqlSessionFactory.openSession();// 获取 sqlSession 他 能够执行 已经映射的sql语句
    }
    @After
    public void close(){
        sqlSession.close();
    }

    @Test
    public void map() { //  P1 sql的唯一标识   P2 执行sql要用的参数
        Map map = sqlSession.selectOne("findMapById",7369);
        System.out.println(map);
    }

    @Test
    public void emp() { //  id: 唯一标识  在多个 xml 中 可以重复  但是在调用时 需要指定 namespace
        Emp emp = sqlSession.selectOne("com.goat.dao.EmpDao.findObjectById",7369);
        System.out.println(emp);
    }

    @Test
    public void dept() {
        Dept dept = sqlSession.selectOne("com.goat.dao.DeptDao.findObjectById",10);
        System.out.println(dept);
    }

    @Test
    public void user() {
        User user = sqlSession.selectOne("com.goat.dao.UserDao.findObjectById",2);
        System.out.println(user);
    }


    @Test
    public void saveMap() {
        Map map = new HashMap();
        map.put("ENAME",123);
        // 插入记录后  会返回  自增主键 存在 map 属性中
        int temp = empDao.saveMap(map);
        System.out.println(temp);
    }
    @Test
    public void saveObject() {
        Emp emp = new Emp();
        emp.setENAME("321");
        int temp = empDao.saveObject(emp);
        System.out.println(temp);
    }

    @Test
    public void deleteById() {
        int temp = empDao.deleteById(55);
        System.out.println(temp);
    }


    @Test
    public void findMapById() {
        Map map = empDao.findMapById(7369);
        System.out.println(map);
    }


    @Test
    public void findObjectById() {
        Emp map = empDao.findObjectById(7369);
        System.out.println(map);
    }


}
