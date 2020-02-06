package cn.goatool.core.reflect;

import cn.goatool.core.reflect.typeparam.Level0Mapper;
import cn.goatool.core.reflect.typeparam.Level1Mapper;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2020/2/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/6---18:13
 */
public class TypeParameterResolverTest {

    /**
     * 测试类型 子类/父类
     * 无参
     * 有返回值(包装类型) Double
    */
    @Test
    public void testReturn_Lv0SimpleClass() throws Exception {
//        Class<?> clazz = Level0Mapper.class; // 父类
        Class<?> clazz = Level1Mapper.class; // 子类
        Method method = clazz.getMethod("simpleSelect");
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(Double.class, result);
    }

    /**
     * 测试类型  子类
     * 有参(包装类型) Integer
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
     * 测试类型  子类
     * 有参(原始类型) int
     * 有返回值(原始类型) double
     */
    @Test
    public void testReturn_SimplePrimitive() throws Exception {
        Class<?> clazz = Level1Mapper.class;
        Method method = clazz.getMethod("simpleSelectPrimitive", int.class);
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(double.class, result);
    }

    @Test
    public void testReturn_SimpleList() throws Exception {
        Class<?> clazz = Level1Mapper.class;
        Method method = clazz.getMethod("simpleSelectList");
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertTrue(result instanceof ParameterizedType);

        ParameterizedType paramType = (ParameterizedType) result;
        assertEquals(List.class, paramType.getRawType());
        assertEquals(1, paramType.getActualTypeArguments().length);
        assertEquals(Double.class, paramType.getActualTypeArguments()[0]);
    }
}
