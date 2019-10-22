package com.goat.others;

import com.goat.entity.Student;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;


/*
*
* 加密认证 登录方式
* 
*
* */
public class MongoCredentialTest {


    @Test
    public void test() {
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("192.168.136.128",27017);
        List<ServerAddress> addrs = new ArrayList<>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  createMongoCRCredential
        MongoCredential credential = MongoCredential.createScramSha1Credential("root", "test", "mongo".toCharArray());
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(credential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);
        MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory( mongoClient , "test"));
        Student p = mongoOps.findOne(Query.query(Criteria.where("name").is("Joe")), Student.class);
        System.out.println(p);
    }


}

