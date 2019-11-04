package com.goat.B.B03.item06;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by 64274 on 2019/4/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/9---18:23
 */
public class DaoFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;
        }
        return 1;
    }

}