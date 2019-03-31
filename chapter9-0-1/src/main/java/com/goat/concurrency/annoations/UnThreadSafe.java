package com.goat.concurrency.annoations;

import java.lang.annotation.*;

/** 非线程安全注解*/
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface UnThreadSafe {
    String value() default "";
}
