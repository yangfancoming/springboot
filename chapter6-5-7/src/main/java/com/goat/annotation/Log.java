package com.goat.annotation;


import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /** 模块名称 */
    String title() default "";

    /** 功能类型 */
    String action() default "";

    /** 料仓编号 */
    String code() default "";

}
