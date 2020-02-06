package cn.goatool.core.reflect;

import cn.goatool.core.reflect.typeparam.Level0Mapper;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2020/2/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/6---18:13
 */
public class TypeParameterResolverTest {

    @Test
    public void testReturn_Lv0SimpleClass() throws Exception {
        Class<?> clazz = Level0Mapper.class;
        Method method = clazz.getMethod("simpleSelect");
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(Double.class, result);
    }
}
