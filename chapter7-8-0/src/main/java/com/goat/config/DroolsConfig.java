package com.goat.config;

import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2025/11/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2025/11/27---14:29
 */
@Configuration
public class DroolsConfig {

    @Bean
    public KieServices kieServices() {
        return KieServices.Factory.get();
    }

    // 核心Bean：KieContainer，它会自动加载 classpath 下的 /META-INF/kmodule.xml
    @Bean
    public KieContainer kieContainer() {
        return kieServices().newKieClasspathContainer();
    }

    // 先创建KieBase的Bean（可选，如果你的Session配置需要它）
    @Bean
    public KieBase kieBase(KieContainer kieContainer) {
        // "goatBase1" 必须与 kmodule.xml 中定义的 kbase name 一致
        return kieContainer.getKieBase("goatBase1");
    }

    // 现在可以注入KieBase来创建KieSession了
    @Bean
    public KieSession kieSession(KieBase kieBase) {
        KieSession kieSession = kieBase.newKieSession();

        // 添加调试监听器
        kieSession.addEventListener(new DebugAgendaEventListener());
        kieSession.addEventListener(new DebugRuleRuntimeEventListener());

        return kieSession;
    }

    // 【可选】配置KieScanner，用于动态更新规则（开发环境好用）
//    @Bean
//    public KieScanner kieScanner(KieContainer kieContainer) {
//        KieScanner kieScanner = kieServices().newKieScanner(kieContainer);
//        kieScanner.start(10000L); // 每10秒扫描一次规则更新
//        return kieScanner;
//    }
//    private static final KieServices kieServices = KieServices.Factory.get();
//    //制定规则文件的路径
//    private static final String RULES_CUSTOMER_RULES_DRL = "rules/order.drl";
//
//    @Bean
//    public KieContainer kieContainer() {
//        //获得Kie容器对象
//        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_CUSTOMER_RULES_DRL));
//
//        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
//        kieBuilder.buildAll();
//
//        KieModule kieModule = kieBuilder.getKieModule();
//        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
//
//        return kieContainer;
//    }
//
//    @Bean
//    public KieSession kieSession(KieBase kieBase) { // 注入KieBase
//        // 从KieBase创建新的KieSession
//        KieSession kieSession = kieBase.newKieSession();
//
//        // 【核心】添加调试监听器
//        kieSession.addEventListener(new DebugAgendaEventListener());
//        kieSession.addEventListener(new DebugRuleRuntimeEventListener());
//
//        return kieSession;
//    }

}

