package com.goat.common;

import com.goat.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @Title：  原生sql 方法
 * @author fan.yang
 * @date 2018年10月9日10:09:38
 */
@Service
public class CommonNativeSqls {


    @PersistenceContext
    private EntityManager entityManager;


    /**
     * @Title：  通过 age  查询 user 对象
     * @author fan.yang
     * @date 2018年10月9日15:01:45
     * @param age
     * @return 返回
     */
    @SuppressWarnings("unchecked")  // 为了 项目编译时  去掉  "XXX使用了未经检查或不安全的操作" 编译警告
    public List<User>  findUserByAge(Integer age) {
        String sql = "select * from user WHERE age = :age ";
        Query query = entityManager.createNativeQuery(sql).setParameter("age",age);
        List<User> users = query.getResultList();
        return users;
    }


    /**
     * @Title： JPA setParameter 方法  作为  SQL语句中 IN 的参数 使用 List ！
     * @author fan.yang
     * @date 2018年10月22日19:21:43
     * @param names  区域名称  'AAA','BBB','CCC'
     * @return 返回
     */
    @SuppressWarnings("unchecked")
    public List<User> getPnCountByRegion(List<String> names) {
        String sql = "SELECT * FROM user WHERE name IN (:names)";
        Query query = entityManager.createNativeQuery(sql); //
        query.setParameter("names",names);
        return query.getResultList();
    }


    /**
     * @Title：  sos  entityManager 的 update 使用方法 ： executeUpdate()
     * @author fan.yang
     * @date 2018年10月9日15:01:45
     * @param age
     * @return 返回
     */
    @SuppressWarnings("unchecked")
    @Transactional  // 如果不加该注解  会报错：  Executing an update/delete query
    public void   updateTest(Integer age,String name) {
        String sql = "UPDATE user SET name = :name WHERE age = :age ";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("age",age);
        query.setParameter("name",name);
        query.executeUpdate(); //
    }


}
