package com.goat;


import com.goat.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private KieSession session;

    @Test
    public void test(){
        //从Kie容器对象中获取会话对象
//        KieSession session = kieContainer.newKieSession();
        //Fact对象，事实对象
        Order order = new Order();
        order.setAmout(1300);
        //将Order对象插入到工作内存中
        session.insert(order);
        //激活规则，由Drools框架自动进行规则匹配，如果规则匹配成功，则执行当前规则
        session.fireAllRules();
        //关闭会话
        session.dispose();
        System.out.println("订单金额：" + order.getAmount() + "，添加积分：" + order.getScore());
    }

}
