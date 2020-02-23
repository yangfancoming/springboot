package com.goat;


import com.goat.chapter001.entity.User;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest extends CommonTest {

    /**
     * @Description: 查询出符合条件的第一个结果，并将符合条件的数据删除,只会删除第一条
     * @author: Goat
     * @Date:   2018/9/27
     */
    @Test
    public void findAndRemove() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("list1"));
        User user = mongoTemplate.findAndRemove(query,User.class);
        System.out.println(user);
    }
    /**
     * @Description: 查询出符合条件的所有结果，并将符合条件的所有数据删除
     * @author: Goat
     * @Date:   2018/9/27
     */
    @Test
    public void findAllAndRemove() {
        Query query = Query.query(Criteria.where("name").is("list2"));
        List<User> articles = mongoTemplate.findAllAndRemove(query, User.class);
        System.out.println(articles);
    }
    /**
         * @Description:  删除 name 为 list2 的数据
         * @author: Goat
         * @Param:
         * @Return:  删除的记录数
         * @Date:   2018/10/6
    */
    @Test
    public void remove() {
        Query query = Query.query(Criteria.where("name").is("list2"));
        DeleteResult deleteResult = mongoTemplate.remove(query, User.class);
        System.out.println(deleteResult.getDeletedCount());
    }

    //删除集合，可传实体类，也可以传名称
    @Test
    public void dropCollection1() {  // 传实体类
        mongoTemplate.dropCollection(User.class);
    }
    @Test
    public void dropCollection2() {  // 传集合名称
        mongoTemplate.dropCollection("stus");
    }

    @Test
    public void dropDatabase() {  // 删除数据库
        MongoDatabase mongoDatabase = mongoTemplate.getDb();
        mongoDatabase.drop();
    }

}


