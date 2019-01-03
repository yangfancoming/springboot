package com.goat;


import com.goat.entity.Student;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateTest extends CommonTest {


    @Test
    public void updateFirst() { // 修改符合条件第一条记录
        //在 students 集合中 修改第一条 gender属性 为 girl 的数据中的 name属性改为 what 和 age 属性 改为 1111
        Query query = Query.query(Criteria.where("gender").is("girl")); // 指定 查询条件
        Update update = Update.update("name", "what").set("age", 1111); // 指定 要修改的属性和值
        UpdateResult temp = mongoTemplate.updateFirst(query, update, Student.class);
        System.out.println(temp.getMatchedCount()); // 返回 匹配到的记录数
    }

    @Test
    public void updateMulti() {  // 修改符合条件的所有
        Query query = Query.query(Criteria.where("gender").is("girl")); // 指定 查询条件
        Update update = Update.update("name", "what").set("age", 1111); // 指定 要修改的属性和值
        UpdateResult temp = mongoTemplate.updateMulti(query,update,Student.class);
        System.out.println(temp.getMatchedCount()); // 返回 匹配到的记录数
    }
    @Test
    public void Upsert() {  // 修改符合条件时 如果不存在则添加
        Query query = Query.query(Criteria.where("gender").is("girl")); // 指定 查询条件
        Update update = Update.update("name", "what").set("age", 1111); // 指定 要修改的属性和值
        UpdateResult temp = mongoTemplate.upsert(query,update,Student.class);
        System.out.println(temp.getMatchedCount()); // 返回 匹配到的记录数
    }

    /**
     * @Description: 功能描述：  查询到指定对象后  进行更改
     * @author: 杨帆
     * @Date:   2018/9/27
     * @Return: p1 返回 修改指定的对象
     */
    @Test
    public void findAndModify() {
        Query query = new Query();
        query.addCriteria(Criteria.where("gender").is("boy"));
        Student student = mongoTemplate.findAndModify(query, new Update().set("name","shit"),Student.class);
        System.out.println(student);
    }
}

