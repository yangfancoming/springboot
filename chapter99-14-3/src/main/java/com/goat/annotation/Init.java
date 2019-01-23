package com.goat.annotation;

import java.lang.annotation.*;

/**
 * Created by 64274 on 2019/1/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/23---10:21
 */
@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
     String value() default "";
}
