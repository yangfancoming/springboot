package com.goat.mytest.goat;


import com.goat.mytest.fly.DeviceType;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

import java.util.List;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2025/3/28
*/
public class GoatNG {


        private static final KieServices kieServices = KieServices.Factory.get();
        //制定规则文件的路径
//        private static final String RULES_CUSTOMER_RULES_DRL = "rules/order.drl";
        private static final String RULES_CUSTOMER_RULES_DRL = "drools/rules/goat/goat.drl";

        public KieSession loadSingleDrl(String path) {
            KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
            kieFileSystem.write(ResourceFactory.newClassPathResource(path));
            KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
            kieBuilder.buildAll();
            KieModule kieModule = kieBuilder.getKieModule();
            KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
            KieSession kieSession = kieContainer.newKieSession();
            return kieSession;
        }

    @Test
    public void test() {
        KieSession kieSession = loadSingleDrl(RULES_CUSTOMER_RULES_DRL);
        Person person = new Person(1,15,"杨帆","上海", DeviceType.SIMULATOR);
        Dept dept = new Dept(1,"开发部");
        person.setDept(dept);

        List<Order> orders =  new java.util.ArrayList<>();
        orders.add(new Order(1,"1000"));
        orders.add(new Order(2,"2000"));
        orders.add(new Order(3,"3000"));
        person.setOrders(orders);


        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void test1() {
        KieSession kieSession = loadSingleDrl(RULES_CUSTOMER_RULES_DRL);
        Person person = new Person(1,15,"杨帆","上海", DeviceType.SIMULATOR);
        Person person2 = new Person(2,20,"宝发","北京", DeviceType.SIMULATOR);
        Dept dept = new Dept(1,"开发部");
        person.setDept(dept);
        person2.setDept(dept);

        List<Order> orders =  new java.util.ArrayList<>();
        orders.add(new Order(1,"1000"));
        orders.add(new Order(2,"2000"));
        person.setOrders(orders);
        orders.add(new Order(3,"3000"));
        person2.setOrders(orders);


        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
