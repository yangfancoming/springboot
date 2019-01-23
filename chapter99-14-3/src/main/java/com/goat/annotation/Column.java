package com.goat.annotation;

import java.lang.annotation.*;

/**
 * Created by 64274 on 2018/12/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/11---21:26
 */
@Retention(RetentionPolicy.RUNTIME) // 指定注解的声明周期： source/class/runtime
@Target(ElementType.FIELD) // 指定注解的使用范围
@Documented // 定义Testable Annotation将被javadoc工具提取
@Inherited // 注解可以被继承
public @interface Column {

    String col_name() default "gaga";
}
