package com.goat;


import com.goat.domain.Customer;
import com.goat.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @Description: 功能描述： JPA 常用查询
 * @author: Goat
 * @Date:  2018年9月28日16:32:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectTest extends TestCommon {

    /**
         * @Description: JPA 自带查询功能
         * @author: Goat
         * @Date:   2018/9/28

     * 需要自定义：
     * findByName()  根据 属性 name 查询
     *
    */

    @Test
    public void findAll() { // findAll()  查询所有记录
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
    @Test
    public void findById() { // findById() 根据主键ID 查询
        Optional<User> users = userRepository.findById(1L);
        System.out.println(users);
    }

    @Test
    public void countByAge() { // 返回匹配条件的记录数
        long count = userRepository.countByAge(20);
        System.out.println(count);
    }


    @Test
    public void findByName() {   // 查询姓名为FFF的User  findByName,
        User user = userRepository.findByName("FFF");
        System.out.println(user);
    }
    @Test
    public void findAndSave() {   // 查询一条记录后  设置一个null属性  在save的 会将对应的表字段 update 为 null
        User user = userRepository.findByName("FFF");
        user.setAge(null);
        User save = userRepository.save(user);
        System.out.println(save);
    }
    @Test
    public void findAndSaveNew() {   // 查询一条记录后  设置一个null属性  在save的 会将对应的表字段 update 为 null
        User user = new User();
        user.setId(5L);
        user.setName("wakaka");
        user.setAge(null);
        User save = userRepository.save(user);
        System.out.println(save);
    }
    @Test
    public void findByLastName() {
        List<Customer> customer = customerRepository.findByLastName("Bauer");
        System.out.println(customer);
    }

    // 通过 name 属性 模糊查询  记录   需要手写  查询符号， 在mongodb中却不需要
    @Test
    public void findByNameLike() {
        String name = "A";
        List<User> users = userRepository.findByNameLike("%"+name+"%");
        System.out.println(users);
    }

    // 查询姓名为FFF的User  findUser,
    @Test
    public void findUser() {
        List<User> users = userRepository.findUser("FFF");
        System.out.println(users);
    }

    //查询姓名为FFF并且年龄为60的User  findByNameAndAge,   And  where x.name = ?1 and x.age = ?2
    @Test
    public void findByNameAndAge() {
        User user = userRepository.findByNameAndAge("FFF", 60);
        System.out.println(user);
    }

    // findByLastnameOrFirstname  Or   where x.lastname = ?1 or x.firstname = ?2
    @Test
    public void findByLastnameOrFirstname() {
        List<Customer> customer = customerRepository.findByLastNameOrFirstName("Jack", "Bauer");
        System.out.println(customer);
    }
}
