package cn.goatool.core.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/12/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/5---9:58
 */
public class ReflectorTest {

    @Test
    public void test() throws NoSuchMethodException {
        Method eat = Human.class.getMethod("eat");
        Assert.assertEquals("void#eat", Reflector.getSignature(eat));

        Method sing = Human.class.getMethod("sing",String.class);
        Assert.assertEquals("void#sing:java.lang.String", Reflector.getSignature(sing));

        Method study = Student.class.getMethod("study",String.class,Integer.class);
        Assert.assertEquals("java.lang.String#study:java.lang.String,java.lang.Integer", Reflector.getSignature(study));
    }

    @Test
    public void getSignature() throws NoSuchMethodException {
        Method humnan_getIds = Human.class.getMethod("getIds");
        Assert.assertEquals("java.util.List#getIds", Reflector.getSignature(humnan_getIds));

        Method student_getIds = Student.class.getMethod("getIds");
        Assert.assertEquals("java.util.ArrayList#getIds", Reflector.getSignature(student_getIds));
    }

    @Test
    public void addUniqueMethods() {
        Map<String, Method> uniqueMethods = new HashMap<>();
        Method[] methods = Student.class.getDeclaredMethods();
        Map<String, Method> map = Reflector.addUniqueMethods(uniqueMethods, methods);
        System.out.println(map);
    }

    @Test
    public void addDefaultConstructor() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = Reflector.getDefaultConstructor(Student.class);
        Object o = constructor.newInstance();
    }


}
