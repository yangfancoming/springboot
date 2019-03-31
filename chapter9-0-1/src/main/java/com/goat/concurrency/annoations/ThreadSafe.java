package com.goat.concurrency.annoations;

import java.lang.annotation.*;

/** 线程安全注解*/

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
