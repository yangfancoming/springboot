package com.goat;



import com.goat.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.BeforeMethod;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest {


    @Autowired
    PersonService personService;

    @Before
    public void test() {
        Person p = new Person();
        p.setAddress("1111");
        p.setAge(11);
        p.setName("goat");
        p.setId(123L);
        personService.findOne(p);
    }

    @Test
    public void save() {
        Person p = new Person();
        p.setId(123L);
        personService.findOne(p);
    }
}
