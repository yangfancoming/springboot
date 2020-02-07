package com.goat;


import com.goat.entity.Student;
import com.goat.chapter001.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Pattern;

/*
db.students.find();

* */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest extends CommonTest {

    @Test
    public void count() {  // 查询指定集合中的所有文档数
        long count = mongoTemplate.count(new Query(),User.class);
        System.out.println(count);
    }

    @Test
    public void findAll() { // 查询指定集合中的所有文档
        List<User> users = mongoTemplate.findAll(User.class);
        System.out.println(users);
    }

    /**
     * @Description: 功能描述：  通过主键id 进行查找单个对象    p1 指定 主键id  p2 指定 要在哪个集合中查找
     * @author: Goat
     * @Date:   2018/9/27
     */
    @Test
    public void findById() {
        User user = mongoTemplate.findById("34",User.class); //sos is后的参数类型必须 有实体类中的一致  String 则 "33"  Integer 则 33
        System.out.println(user);
    }

    @Test
    public void findOne() {  // 查询 集合中符合条件的第一个文档
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("list2"));
        User user = mongoTemplate.findOne(query,User.class);
        System.out.println(user);
    }


    /**
     * @Description: 功能描述：  通过某个属性匹配指定值  进行查找
     * @author: Goat
     * @param  p1 指定  查询属性及对应值
     * @param  p2 指定 要在哪个集合中查找
     * @Date:   2018/9/27
     */
    @Test
    public void findByQuery() {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is("于")); // 查询条件一
        query.addCriteria(Criteria.where("name").is("起宇")); // 查询条件二
        List<User> user = mongoTemplate.find(query,User.class);
        System.out.println(user);
    }

    /**
     * @Description: 在 Query 中加入排序 功能  P1   P2 指定
     * @author: Goat
     * @param  p1 指定 升序/降序
     * @param  p2 指定 对那个属性进行排序
     * @Date:   2018/9/27
     */
    @Test
    public void sort() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("list2"));
        query.with(new Sort(Sort.Direction.DESC,"id"));
        List<User> user = mongoTemplate.find(query,User.class);
        System.out.println(user);
    }

    /**
    完全匹配
    Pattern pattern = Pattern.compile("^hzb$", Pattern.CASE_INSENSITIVE);
    右匹配
    Pattern pattern = Pattern.compile("^.*hzb$", Pattern.CASE_INSENSITIVE);
    左匹配
    Pattern pattern = Pattern.compile("^hzb.*$", Pattern.CASE_INSENSITIVE);
    模糊匹配
    Pattern pattern = Pattern.compile("^.*hzb.*$", Pattern.CASE_INSENSITIVE);
     */
    @Test
    public void selectLike() {
        Query query = new Query();
        Pattern pattern = Pattern.compile("^.*is.*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("name").regex(pattern));
        List<User> user = mongoTemplate.find(query,User.class);
        System.out.println(user);
    }

    @Test
    public void gtlt() {
        Criteria temp = new Criteria();
        Criteria criteria1 = Criteria.where("age").gt(8); // 年龄 大于 8
        Criteria criteria2 = Criteria.where("age").lt(25);  // 年龄 小于 25
        temp.andOperator(criteria1,criteria2);
        Query query = Query.query(temp);
        List<Student> students = mongoTemplate.find(query,Student.class);
        System.out.println(students);
    }
    /**
         * @Description: 投影  include()和exclude() 方法用于包含或排除某个字段
         * @author: Goat
         * @Date:   2018/10/6
     *
    当通过投影获取数据时，在结果的类实例中，被排除的字段是null
    */
    @Test
    public void include() {
        Query query = new Query();
        query.fields().include("name");
        List<Student> students = mongoTemplate.find(query, Student.class);
        System.out.println(students);
    }
    @Test
    public void exclude() {
        Query query = new Query();
        query.fields().exclude("name");
        List<Student> students = mongoTemplate.find(query, Student.class);
        System.out.println(students);
    }



}
