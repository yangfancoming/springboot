package com.goat.myimport3;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/27---22:02
 */

@Component
@Import(value = { MyImportSelector.class })
@EnableLogInfo(name="onlySale")
/**
 * Bean的批量注入 使用自定义 ImportSelector 须实现 ImportSelector
 * 接口，返回值必须是class全称测集合，该集合内的所有类都将被Spring IOC容器统一管理
 * ***---***myImportSelector
 * ***---***com.goat.myimport3.Sales
 *
 * 代码解读：此处使用了@Import注解和实现了 ImportSelector 来注入Bean
 * 代码逻辑：通过 实现 ImportSelector 获得 importingClassMetadata 对象，然后再由 importingClassMetadata 获得 我们自定的@EnableLogInfo 中的 值，如果 该值包含 onlySale 则 我们只装配Sale 类实例，否则 装配 Sale 和Market 两个类的实例。

 */
public class MyImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        System.out.println(importingClassMetadata.getAnnotationAttributes(EnableLogInfo.class.getName()).toString().contains("onlySale"));

        //获取自定的@EnableLogInfo 信息 如果包含 onlySale 则只注入Sales class 否则 注入 Sales 和 Market 两个类
        if (importingClassMetadata.getAnnotationAttributes(EnableLogInfo.class.getName()) != null
                && importingClassMetadata.getAnnotationAttributes(EnableLogInfo.class.getName()).toString().contains("onlySale")) {
            return new String[] {Sales.class.getName() };
        }
        // 将指定的类
        return new String[] { Market.class.getName(), Sales.class.getName() };
    }
}
