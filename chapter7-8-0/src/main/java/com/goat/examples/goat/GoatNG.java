package com.goat.examples.goat;


import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2025/3/28
*/
public class GoatNG {


    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("goat2");

        Person person = new Person("yang",15);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
