package com.goat.entityManager;


import com.goat.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
     * @Description: 功能描述：   JPA 实体管理器  EntityManager
     * @author: Goat
     * @Date:   2018年12月12日21:07:32

*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class createQuery {

    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void createNativeQuery() {
        String sql = "select p from User p";
        Query query = entityManager.createQuery(sql);
        List<User> users = query.getResultList();
        System.out.println(users);
    }

}
