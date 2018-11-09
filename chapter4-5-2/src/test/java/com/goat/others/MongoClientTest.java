package com.goat.others;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoClientTest {

    @Resource
    private MongoClient mongoClient;

    @Test
    public void testBatchInsert() {
        List<Document> list = new ArrayList<>();
        MongoCollection<Document> collection = mongoClient.getDatabase("test").getCollection("book");
        for (int i = 0; i < 5; i++){
            Document document = new Document();
            document.append("id", String.valueOf(i));
            Date date = new Date();
            document.append("add_time", date);
            document.append("title", "mongo"+i++);
            list.add(document);
            System.out.println("插入" + " " + i + "本书");
        }
        collection.insertMany(list);
    }

}

