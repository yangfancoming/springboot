package com.goat.joinColumn;


import com.goat.domain.Customer;
import com.goat.domain.Order;
import com.goat.repository.CustomerRepository;
import com.goat.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


/**
     * @Description: 功能描述：
     * @author: 杨帆
     * @Date:  2018年12月12日21:28:12

*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToOneTest {

    @Autowired  CustomerRepository customerRepository;
    @Autowired  OrderRepository orderRepository;

/**
     * @Description:  单向一对多   Customer 为一   Order 为 多
     * @author: 杨帆
     * @Date:   2018/12/12
*/
    @Test
    public void manyToOneSave() {
        Customer customer = new Customer();
        customer.setFirstName("gaga");
        customer.setLastName("fafa");

        Order order1 = new Order("dudu",false);
        order1.setCustomer(customer); // 绑定表关系
        Order order2 = new Order("didi",true);
        order2.setCustomer(customer); // 绑定表关系
        // 建议 优先保存 1 的一端  后保存 N 的一端  ，否则的话  N 端 先插入后 外键为空，  1 插入后 有了外键后 N 端还要再次 update
        customerRepository.save(customer);

        orderRepository.save(order1);
        orderRepository.save(order2);
    }

    // FetchType.EAGER
    @Test
    public void EAGER() {
        Optional<Order> byId = orderRepository.findById(3L); // 由于 被查询对象 有外键关联 所以这里 执行了两次查询  一次查询对象 一次查询外键对象
        Order order = byId.get(); // 通过主键id 查询到 对象
        System.out.println(order);
        System.out.println(order.getCustomer().getFirstName()); // 通过对象外键 获取到 关联对象
    }
    // FetchType.EAGER
    @Test
    public void EAGER1() {
        Order order = orderRepository.findById(3L).get(); // 由于 被查询对象 有外键关联 所以这里 执行了两次查询  一次查询对象 一次查询外键对象
        System.out.println(order);
        System.out.println(order.getCustomer().getFirstName()); // 通过对象外键 获取到 关联对象
    }
    // FetchType.LAZY
    @Test
    public void LAZY() {
        Optional<Order> byId = orderRepository.findById(3L); //  懒加载 方式： 这次只查询一次  查询对象
        Order order = byId.get(); // 通过主键id 查询到 对象
        System.out.println(order);
        System.out.println(order.getCustomer().getFirstName()); //  这里 在用到外键对象时 再查询一次外键对象
    }

    /**
     删除  1 端 其有两个 N 端关联  但是 并没有 报错：No class com.goat.domain.Order entity with id 2 exists!   还是可以删除
     那么  那两个 N 端 就这样一直残留在数据库中？
     */
    @Test
    public void deleteById() {
        customerRepository.deleteById(2L);
    }

    @Test
    public void deleteB1yId() {
        Optional<Order> byId = orderRepository.findById(6L);//
        Order order = byId.get();
        order.getCustomer().setLastName("goat1111"); // 若 1 端 已经被删除 那么 报错  java.util.NoSuchElementException: No value present
        customerRepository.save(order.getCustomer());// 若 1 端 还在 则 成功修改
    }


}
