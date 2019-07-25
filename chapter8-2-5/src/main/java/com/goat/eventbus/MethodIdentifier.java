package com.goat.eventbus;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by 64274 on 2019/7/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/25---23:07
 */
public class MethodIdentifier {

    private final String name;
    private final List<Class<?>> parameterTypes;

    MethodIdentifier(Method method) {
        this.name = method.getName();
        this.parameterTypes = Arrays.asList(method.getParameterTypes());
    }


    @Override
    public boolean equals( Object o) {
        if (o instanceof MethodIdentifier) {
            MethodIdentifier ident = (MethodIdentifier) o;
            return name.equals(ident.name) && parameterTypes.equals(ident.parameterTypes);
        }
        return false;
    }
}
