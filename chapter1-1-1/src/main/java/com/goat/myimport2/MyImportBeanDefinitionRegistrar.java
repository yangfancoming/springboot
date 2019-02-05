package com.goat.myimport2;

/**
 * Created by 64274 on 2019/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/27---21:57
 */

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * registerBeanDefinitions 方法中的参数 BeanDefinitionRegistry 可以往Spring IOC Container 中动态地装配Bean
 * ***---***forwards
 * ***---***security
 * ***---***MyImportBeanDefinitionRegistrar
 */
@Component
@Import(MyImportBeanDefinitionRegistrar.class)
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //手动注入 Forwards 类的实例
        BeanDefinitionBuilder beanDef_forwards = BeanDefinitionBuilder.rootBeanDefinition(Forwards.class);
        registry.registerBeanDefinition("forwards", beanDef_forwards.getBeanDefinition());

        //手动注入 Security类的实例
        BeanDefinitionBuilder beanDef_security = BeanDefinitionBuilder.rootBeanDefinition(Security.class);
        registry.registerBeanDefinition("security", beanDef_security.getBeanDefinition());
    }

}