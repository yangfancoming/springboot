package com.goat.entityManager;


import com.goat.domain.User;
import com.goat.domain.User2;
import org.hibernate.SQLQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
     * @Description: 功能描述：   JPA 实体管理器  EntityManager
     * @author: 杨帆
     * @Date:   2018/9/10
 * @PersistenceContext 注入的是实体管理器，执行持久化操作的，需要配置文件persistence.xml。
注入一堆保存实体类状态的数据结构，针对实体类的不同状态(四种,managedh或detached等)可以做出不同的反应(merge,persist等等)
其实就是把数据从数据库里提出，然后在内存里处理的，再返回数据库的法则。
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class createNativeQuery  {

    @PersistenceContext
    private EntityManager entityManager;

    /**
         * @Description: 功能描述： createNativeQuery
         * @author: 杨帆
    在JPA 2.0 中我们可以使用entityManager.createNativeQuery()来执行原生的SQL语句。
    但当我们查询结果没有对应实体类时，query.getResultList()返回的是一个List<Object[]>。
    也就是说每行的数据被作为一个对象数组返回。

    // 第一个直接传入原生sql语句:
    public Query createNativeQuery(String sqlString);
    // 第二个传入原生sql和需要映射的实体类:
    public Query createNativeQuery(String sqlString, Class resultClass);
    public Query createNativeQuery(String sqlString, String resultSetMapping);

    */
    @Test
    public void createNativeQuery() {
        String sql = "select * from user";
        Query query = entityManager.createNativeQuery(sql);
        List<User> users = query.getResultList();
        System.out.println(users);
    }

    // sos 细节： 如果没有查询到结 那么 getResultList() 最多size为0 ,并不会报空异常 而 getSingleResult() 会报空异常！！！
    @Test
    public void createNa1tiveQuery() {
        String sql = "select name from user";
        Query query = entityManager.createNativeQuery(sql);
//        Object users = query.getSingleResult(); // 报错： 空异常
        List<String> users = query.getResultList(); // 不报错： size=0
        if(users.size()==0){
            System.out.println(users.size());
        }else {
            System.out.println(users.get(0));
        }
    }
    /**
         * @Description: 功能描述： createNativeQuery 执行原生sql  传参方法
         * @author: 杨帆
         * @Date:   2018/9/11
    // 第一个直接传入原生sql语句:
    public Query createNativeQuery(String sqlString);
    users  是没有属性的！ 不信就打断点看看
    */
    @Test
    public void test() {
        String sql = "SELECT * FROM user  WHERE name = ?";
        Query query = entityManager.createNativeQuery(sql).setParameter(1,"BBB"); // 按  位置 输入参数
        List<User> users = query.getResultList();
        System.out.println(users);
    }

    @Test
    public void test1() {
        String sql = "SELECT * FROM user  WHERE name = :name";
        Query query = entityManager.createNativeQuery(sql).setParameter("name","BBB"); // 按 名称 输入参数
        List<User> users = query.getResultList();
        System.out.println(users);
    }


    /**
         * @Description: 功能描述：
         * @author: 杨帆
         * @Date:   2018/9/11
    // 第二个传入原生sql和需要映射的实体类:
    public Query createNativeQuery(String sqlString, Class resultClass);
    users  是带有属性的！ 不信就打断点看看
    */
    @Test
    public void test2() {
        String sql = "SELECT * FROM user  WHERE name = :name";
        Query query = entityManager.createNativeQuery(sql,User.class).setParameter("name","BBB");
        List<User> users = query.getResultList();
        System.out.println(users);
    }

    /**
         * @Description:  报错 org.hibernate.MappingException: Unknown entity: com.goat.domain.User2
         * @author: 杨帆
         * @Date:   2018/9/12
     *  createNativeQuery 的第二个参数 必须要有要  @Entity  @Table(name = "user") 两个注解进行修饰  否则 就会报错
    */
    @Test
    public void test3() {
        String sql = "SELECT * FROM user u  WHERE name = :name";
        Query query = entityManager.createNativeQuery(sql,User2.class).setParameter("name","BBB");
        List<User2> users = query.getResultList();
        System.out.println(users);
    }

    /**
         * @Description:  对于多表关联查询  结果返回多表内容，具体实体类无法满足需求。需要使用以下方法 用Map来接收多表查询结果  JPA返回Map类型
         * @author: 杨帆
         * @Date:   2018/9/12
    */
    @Test
    public void test4() {
        String sql = "SELECT * FROM user u LEFT JOIN salgrade s ON u.id = s.GRADE WHERE u.id = :id";
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("id","3");
        Query query = setParam(entityManager.createNativeQuery(sql), paramMap);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);// 这句代码是关键！
        List<Map<String, Object>> users = query.getResultList();
        System.out.println(users);
    }

    public Query setParam(Query query, Map<String, ? extends Object> paramMap){
        if (paramMap != null) {
            Set<String> mapSet = paramMap.keySet();
            for (String key : mapSet) {
                query.setParameter(key, paramMap.get(key));
            }
        }
        return query;
    }
}
