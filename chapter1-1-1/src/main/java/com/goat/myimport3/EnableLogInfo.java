package com.goat.myimport3;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by 64274 on 2019/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/27---22:02
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MyImportSelector.class)
/**
 *自定义Enable*
 *1.
 */
public @interface EnableLogInfo {
    String[] name();
}
