package com.goat.examples.goat;


import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;


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
        Person person = new Person(1,"杨帆","上海",15);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
