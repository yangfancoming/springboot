package cn.goatool.core.reflect;

import cn.goatool.core.reflect.typeparam.Level1Mapper;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

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
     *  Double simpleSelect();
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
     * void simpleSelectVoid(Integer param);
     */
    @Test
    public void testReturn_SimpleVoid() throws Exception {
        Class<?> clazz = Level1Mapper.class; // 迁移到方法外后 IDEA 就没有方法的自动提示/跳转功能了。。。
        Method method = clazz.getMethod("simpleSelectVoid", Integer.class);
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(void.class, result);
    }

    /**
     * 测试类型  子类
     * double simpleSelectPrimitive(int param);
     */
    @Test
    public void testReturn_SimplePrimitive() throws Exception {
        Class<?> clazz = Level1Mapper.class;
        Method method = clazz.getMethod("simpleSelectPrimitive", int.class);
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertEquals(double.class, result);
    }

    /**
     * 测试类型  子类
     * List<Double> simpleSelectList();
    */
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

    /**
     * 测试类型  子类
     * Map<Integer, Double> simpleSelectMap();
     */
    @Test
    public void testReturn_SimpleMap() throws Exception {
        Class<?> clazz = Level1Mapper.class;
        Method method = clazz.getMethod("simpleSelectMap");
        Type result = TypeParameterResolver.resolveReturnType(method, clazz);
        assertTrue(result instanceof ParameterizedType);
        ParameterizedType paramType = (ParameterizedType) result;
        assertEquals(Map.class, paramType.getRawType());
        assertEquals(2, paramType.getActualTypeArguments().length);
        assertEquals(Integer.class, paramType.getActualTypeArguments()[0]);
        assertEquals(Double.class, paramType.getActualTypeArguments()[1]);
    }
}
