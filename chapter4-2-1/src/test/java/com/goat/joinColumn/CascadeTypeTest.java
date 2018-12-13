package com.goat.joinColumn;

import com.goat.domain.Customer;
import com.goat.domain.Order;
import com.goat.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 64274 on 2018/12/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/13---10:26
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CascadeTypeTest {

    @Autowired
    OrderRepository orderRepository;
    /*
     *
     *  Order 类中 若加上  @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST) 则 保存order时 会自动级联保存其对应的 Customer
     *             若加上  @ManyToOne(fetch = FetchType.EAGER)  则 保存order时 会报错 ：
     *                     object references an unsaved transient instance - save the transient instance before flushing : com.goat.domain.Order.customer
     *                     需要 手动 customerRepository.save(customer); 来保存其级联对象
     * */
    @Test
    public void PERSIST() {
        Customer customer = new Customer();
        customer.setFirstName("333");
        customer.setLastName("444");
        Order order = new Order("333444",true);
        order.setCustomer(customer); // 绑定表关系
        orderRepository.save(order);
    }
//

    /*
    *    级联删除操作。 删除当前实体时，与它有映射关系的实体也会跟着被删除。
    *    Hibernate: delete from t_order where id=?
    *    Hibernate: delete from customer where id=?
    *    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)  删除Order记录后  其外键对应的 Customer 表中的记录 也会被删除
    *    如果不加 cascade=CascadeType.REMOVE  则 只删除 Order 记录！
    * */
    @Test
    public void REMOVE() {
        orderRepository.deleteById(7L);
    }

}
