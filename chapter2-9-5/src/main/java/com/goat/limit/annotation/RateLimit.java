package com.goat.limit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述: 限流注解
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimit {

    /*** 限流唯一标示 */
    String key() default "";

    /*** 限流时间 */
    int time();

    /*** 限流次数 */
    int count();
}
