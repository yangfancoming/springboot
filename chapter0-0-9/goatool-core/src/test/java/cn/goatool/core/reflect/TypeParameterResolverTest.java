package cn.goatool.core.reflect;

import cn.goatool.core.reflect.typeparam.Level0Mapper;
import cn.goatool.core.reflect.typeparam.Level1Mapper;
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

    /**
     * 测试类型 无继承关系
     * 无参
     * 有返回值(包装类型)
    */
    @Test
    public void testReturn_Lv0SimpleClass() throws Exception {
        Class<?> clazz = Level0Mapper.class;
        Method method = clazz.getMethod("simpleSelect");
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(Double.class, result);
    }

    /**
     * 测试类型  有继承关系
     * 有参(包装类型)
     * 无返回值
     */
    @Test
    public void testReturn_SimpleVoid() throws Exception {
        Class<?> clazz = Level1Mapper.class;
        Method method = clazz.getMethod("simpleSelectVoid", Integer.class);
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(void.class, result);
    }

    /**
     * 测试类型  有继承关系
     * 有参(原始类型)
     * 有返回值
     */
    @Test
    public void testReturn_SimplePrimitive() throws Exception {
        Class<?> clazz = Level1Mapper.class;
        Method method = clazz.getMethod("simpleSelectPrimitive", int.class);
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(double.class, result);
    }
}
