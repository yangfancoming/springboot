package com.goat.annotation;

import java.lang.annotation.*;

/**
 * Created by 64274 on 2018/12/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/11---21:26
 */
@Retention(RetentionPolicy.RUNTIME) // 指定注解的生命周期： source/class/runtime
@Target(ElementType.TYPE) // 指定注解的使用范围
@Documented // 定义Testable Annotation将被javadoc工具提取
public @interface Table {

    String tb_name() default "haha";

}
