package com.goat.others;


import com.goat.CommonTest;
import com.goat.model.Address;
import com.goat.model.Favorites;
import com.goat.model.Person;
import com.mongodb.client.result.UpdateResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelTest extends CommonTest {

    @Test
    public void Before() { //
        Person user1 = new Person();
        user1.setUsername("tom");
        user1.setAge(8);
        user1.setCountry("Englan");
        user1.setLenght(1.70f);
        user1.setSalary(new BigDecimal(10000));
        Address address1 = new Address();
        address1.setaCode("0000");
        address1.setAdd("XXXXXXXXX");
        user1.setAddress(address1);
        Favorites favorites1 = new Favorites();
        favorites1.setCities(Arrays.asList("广州", "深圳"));
        favorites1.setMovies(Arrays.asList("西游记", "水浒传"));
        user1.setFavorites(favorites1);

        Person user2 = new Person();
        user2.setUsername("tom");
        user2.setAge(38);
        user2.setCountry("USA");
        user2.setLenght(1.70f);
        user2.setSalary(new BigDecimal(10000));
        Address address2 = new Address();
        address2.setaCode("1111");
        address2.setAdd("YYYYYYYYYY");
        user2.setAddress(address2);
        Favorites favorites2 = new Favorites();
        favorites2.setCities(Arrays.asList("南宁", "衡阳"));
        favorites2.setMovies(Arrays.asList("红楼梦", "三国演义"));
        user2.setFavorites(favorites2);
        mongoTemplate.insertAll(Arrays.asList(user1, user2));
    }




    @Test
    public void gtlt() { // gt和lt 都是开区间
        List<Person> students = mongoTemplate.find(Query.query(new Criteria().andOperator(Criteria.where("age").gt(8), Criteria.where("age").lt(25))),Person.class);
        System.out.println(students);
    }

    /**
     * 更新测试
     */
    @Test
    public void testUpdate1() {
        // update users set age = 10 where username = 'tom'
        UpdateResult updateResult = mongoTemplate.updateMulti(Query.query(Criteria.where("username").is("tom")),Update.update("age", 10), Person.class);
        System.out.println(updateResult.getMatchedCount());
        System.out.println(updateResult.getModifiedCount());
    }

    // update users set favorites.movies add "蜘蛛侠","钢铁侠" where favorites.cities has "深圳"
    @Test
    public void testUpdate2() {
        // 查找集合中 favorites.cities 属性中包含有 深圳 的所有记录
        Query query = Query.query(Criteria.where("favorites.cities").is("深圳"));
        // 将 favorites.movie 属性中  插入 数组  "钢铁侠", "蜘蛛侠"
        Update update = new Update().addToSet("favorites.movies").each("钢铁侠", "蜘蛛侠");
        UpdateResult updateResult2 = mongoTemplate.updateMulti(query, update, Person.class);
        System.out.println(updateResult2.getMatchedCount());
        System.out.println(updateResult2.getModifiedCount());
    }



    /**
     * 查询测试-------将Document修改为User即可，其它不需要修改
     */
    @Test
    public void testFind1() {
        // select * from users where favorites.cities has "深圳"、"广州"
        List<Person> find = mongoTemplate.find(Query.query(Criteria.where("favorites.cities").all(Arrays.asList("深圳", "广州"))),Person.class);
        System.out.println(find);
    }
    @Test
    public void testFind2() {
        // select * from users where username like '%om%' and (contry=Englan or contry=USA)
        Pattern pattern = Pattern.compile(".*om.*", Pattern.CASE_INSENSITIVE);
        Criteria regex = Criteria.where("username").regex(pattern);
        Criteria or1 = Criteria.where("country").is("Englan");
        Criteria or2 = Criteria.where("country").is("USA");
        Criteria or = new Criteria().orOperator(or1, or2);
        Query query = Query.query(new Criteria().andOperator(regex, or));
        List<Person> find2 = mongoTemplate.find(query, Person.class);
        System.out.println(find2);
    }
}

