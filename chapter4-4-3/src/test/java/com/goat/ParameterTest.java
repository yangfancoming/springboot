package com.goat;


import com.goat.entity.Dept;
import com.goat.dao.DeptDao;
import com.goat.dao.EmpDao;
import com.goat.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParameterTest {

    @Autowired private DeptDao deptDao;
    @Autowired private EmpDao empDao;


    /**  【传入 多个参数】
     *  SELECT * FROM dept WHERE DEPTNO = #{id} AND DNAME = #{dname} 报错：
     *  Caused by: org.apache.ibatis.binding.BindingException: Parameter 'id' not found. Available parameters are [arg1, arg0, param1, param2]
     *
     * Mybatis 两个参数的传递
     * 1. sql 映射语句中 干掉  parameterType  属性
     * 2. sql 映射语句中 使用  arg0     arg1 接收    SELECT * FROM dept WHERE DEPTNO = #{arg0}   AND DNAME = #{arg1}
     * 3. sql 映射语句中 使用 param1  param2 接收    SELECT * FROM dept WHERE DEPTNO = #{param1} AND DNAME = #{param2}
    */
    @Test
    public void test1() {
        Dept dept = deptDao.findObjectBy2(30,"SALES");
        System.out.println(dept);
    }


    /**   【命名参数】
     若 真想使用  SELECT * FROM dept WHERE DEPTNO = #{id} AND DNAME = #{dname}  方式
     那么，就需要在接口上 加入 @Param("id") @Param("dname") 注解
    */
    @Test
    public void test2() {
        Dept dept = deptDao.findObjectBy22(30,"SALES");
        System.out.println(dept);
    }


/**
     * @Description:  【传入 Map】
     * @author: 杨帆
     * @Date:   2018/10/25
*/
    @Test
    public void updateMapById() {
        Map map = new HashMap();
        map.put("ENAME","nani");
        map.put("id",33);
        int temp = empDao.updateMapById(map);
        System.out.println(temp);
    }

    /**
     * @Description:  【传入 pojo】
     * @author: 杨帆
     * @Date:   2018/10/25
     */
    @Test
    public void updateObjectById() {
        Emp emp = new Emp();
        emp.setEmpno(33);
        emp.setEname("shithaha");
        int temp = empDao.updateObjectById(emp);
        System.out.println(temp);
    }

    /**
         * @Description:  【#{} 与 ${} 的 区别】
    区别：
    #{}:是以预编译的形式，将参数设置到sql语句中；PreparedStatement；防止sql注入
    ${}:取出的值直接拼装在sql语句中；会有安全问题； 常用的 动态传入 表名 和 列名
    大多情况下，我们去参数的值都应该去使用#{}；

    可以看到 控制台日志 打印的SQL 中  ${id} 被直接拼接在了 SQL 中 而  #{DNAME} 是预编译的参数
    DEBUG - ==>  Preparing: SELECT * FROM dept WHERE DEPTNO = 30 AND DNAME = ?
    DEBUG - ==> Parameters: SALES(String)
    DEBUG - <==      Total: 1
         * @Date:   2018/10/25
    */

    @Test
    public void findObjectBy222() {
        Dept dept = deptDao.findObjectBy222(30,"SALES");
        System.out.println(dept);
    }

//    SELECT * FROM ${tableName} WHERE ${columnName} = #{ID}
    @Test
    public void dynamic1() {
        Map<String,Object> map = new HashMap<>(16);
        map.put("tableName","dept");
        map.put("columnName","DEPTNO");
        map.put("ID",30);
        Map<String,Object> result = deptDao.dynamic1(map);
        System.out.println(result);
    }
}
