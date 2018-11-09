package com.goat.others;

import com.goat.bean.Student;
import com.goat.model.Person;
import com.mongodb.MongoClient;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Update.update;


public class MongoOperationsTest  {

    public final Logger log = LoggerFactory.getLogger(this.getClass());

    MongoClient mongoClient = new MongoClient("172.16.163.135", 27017);
    MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory( mongoClient , "database"));

    @Test
    public void insert() {
        Student student = new Student("Joe", 34,"girl");
        mongoOps.insert(student);
        log.info("insert -------------->" + student );
    }
    @Test
    public void findById() {
        Student student = mongoOps.findById("5bb9b2a7766b333fc07d59a3", Student.class);
//        log.info("Found: " + student);
    }
    @Test
    public void updateFirst() {
        // 根据条件 匹配到第一个符合条件的记录   然后对其进行更改
        UpdateResult updateResult =mongoOps.updateFirst(Query.query(Criteria.where("name").is("Joe")), update("age", 35), Student.class);
        log.info(String.valueOf(updateResult.getMatchedCount()));

        // 更改后 通过对应属性进行查询  验证是否 修改成功
        Student p = mongoOps.findOne(Query.query(Criteria.where("name").is("Joe")), Student.class);
        log.info("Updated: " + p);
    }

    @Test
    public void remove() {
        Student p = mongoOps.findOne(Query.query(Criteria.where("name").is("Joe")), Student.class);
        DeleteResult deleteResult = mongoOps.remove(p);
        log.info(String.valueOf(deleteResult.getDeletedCount()));
    }

    @Test
    public void dropCollection() {
        // 删除整个集合
        mongoOps.dropCollection(Student.class);
    }
}

