package com.goat;


import com.goat.dao.Test2Dao;
import com.goat.model.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {

    @Autowired private Test2Dao test2Dao;

    /**
    Mybatis 参数传值 ：
    单个参数： mybatis 不会做处理  所以 #{ 参数名} 中的参数名 可以随意写
    多个参数： mybatis 会做特殊处理   多个参数会被封装成一个map
                key： param1.....paramN
                value： 传入的参数
               #{ } 则是从map中获取指定key的值
     命名参数：@param("明确指定")
             key： @param 注解中指定的值
             value： 传入的参数
             #{ } 则是从map中获取指定key的值

     如果参数很多 可以传入 pojo
            #{ 属性名 } 即可取出传入的pojo的属性值

     也可以传入 Map
            #{ 属性名 } 即可取出传入的pojo的属性值

     Emp findObject(Emp emp);
     Map findMap(Map map);
     Emp findObject1(Integer id,String name);
     Emp findObject2(Integer id,String name);

     取参总结：
     Emp findObject3(@Param("id") Integer id, String name);
     取值： id ==》 #{id/param1}  name ==》 #{param2}

     Emp findObject1(Integer id,@Param("e")Emp emp);
     取值：id ==》 #{param1}  name ==》 #{param2.name/e.name}

     特别注意：如果是 如果是Collection(list,set)类型、数组类型 mybatis也会特殊处理
     key：Collection==> collection  如果是list 还可以使用 list  数组 array
     Emp findObject(List<Integer> ids);
     取值：取出第一个id值  #{list[0]}

    */


    // 报错： BindingException: Parameter 'EMPNO' not found. Available parameters are [arg1, arg0, param1, param2]
    @Test
    public void findObject1() {
        Emp temp = test2Dao.findObject1(33,"shit");
        System.out.println(temp);
    }

    // 通过 xml 中指定 param1 param2 解决  但是 该方法 不是很理想
    @Test
    public void findObject2() {
        Emp temp = test2Dao.findObject2(33,"shit");
        System.out.println(temp);
    }

    // 进一步 优化  使用 @param 明确指定 传入参数名称
    @Test
    public void findObject3() {
        Emp temp = test2Dao.findObject3(33,"shit");
        System.out.println(temp);
    }

    // 再进一步  使用 pojo 传递
    @Test
    public void findObject() {
        Emp emp = new Emp();
        emp.setEMPNO(33);
        emp.setENAME("shit");
        Emp temp = test2Dao.findObject(emp);
        System.out.println(temp);
    }

    // 再进一步  使用 Map 传递
    @Test
    public void findMap() {
        Map map = new HashMap();
        map.put("EMPNO",33);
        map.put("ENAME","shit");
        Map temp = test2Dao.findMap(map);
        System.out.println(temp);
    }
}
