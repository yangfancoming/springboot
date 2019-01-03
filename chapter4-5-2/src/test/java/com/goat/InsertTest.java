package com.goat;


import com.goat.entity.Student;
import com.goat.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;



/*
    向数据库插入文档
        db.<Collection>.insert(文档)
        - 向集合中插入一个或多个文档
        - 当我们向集合中插入文档时，如果没有给文档指定_id属性，则数据库会自动为文档添加_id 该属性用来作为文档的唯一标识
        - _id我们可以自己指定，如果我们指定了数据库就不会在添加了，如果自己指定_id 也必须确保它的唯一性
    db.collection.insertOne()  - 插入一个文档对象
    db.collection.insertMany()   - 插入多个文档对象

插入一个文档---传递一个对象
db.students.insert({name:"goat",age:28,gender:"boy"});

插入多个文档---传递一个数组(集合)
db.students.insert([
    {name:"dog",age:38,gender:"girl"},
    {name:"cat",age:16,gender:"boy"},
    {name:"pig",age:14,gender:"girl"}
]);
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest extends CommonTest {


    /**
     * sava 方法 有则 更新  没有则 插入
     * insert 方法 直接 插入
     */

    @Test
    public void save1() { //  Save the object to the default collection
        User user = new User("33","fuck33");
        mongoTemplate.save(user);
    }
    @Test
    public void save11() { // Save the object to the specified collection
        User user = new User("33","fuck33");
        mongoTemplate.save(user, "students");
    }
    @Test
    public void save2() {
        User user = new User("34","fuck34");
        mongoTemplate.save(user);
    }


    List<User> users = new ArrayList<>();
    @Before
    public void Before() {
        User user1 = new User();
        user1.setName("list1");
        User user2 = new User();
        user2.setName("list2");
        users.add(user1);
        users.add(user2);
    }

    @Test
    public void insert1() { //  insert the object to the default collection
        User user = new User("fuck");
        mongoTemplate.insert(user);
    }
    @Test
    public void insert2() { // insert the object to the specified collection
        User user = new User("fuck123");
        mongoTemplate.insert(user,"students");
    }

    @Test
    public void insert3() { //   insert 默认集合
        mongoTemplate.insert(users,User.class);
    }

    @Test
    public void insert() { //   insert 指定集合
        List<User> lists = new ArrayList<>();
        User user1 = new User("fuck111");
        User user2 = new User("fuck222");
        lists.add(user1);
        lists.add(user2);
        mongoTemplate.insert(lists,Student.class);
    }

    @Test
    public void insertAll() { //   insert 插入集合
        mongoTemplate.insertAll(users);
    }
}

