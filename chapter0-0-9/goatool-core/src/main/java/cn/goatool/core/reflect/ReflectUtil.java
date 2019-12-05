package cn.goatool.core.reflect;


import java.lang.reflect.Method;


public class ReflectUtil {

    /**
     *  给指定方法生成唯一签名  生成签名的规则是： 方法返回值#方法名#参数名
     * @param method  待生成唯一签名的方法
     * 输入示例：  Method eat = Human.class.getMethod("eat");
     * 输出结果：  Assert.assertEquals("void#eat", ReflectUtil.getSignature(eat));
     *
     * 输入示例：  Method sing = Human.class.getMethod("sing",String.class);
     * 输出结果：  Assert.assertEquals("void#sing:java.lang.String", ReflectUtil.getSignature(sing));
     *
     * 输入示例：  Method study = Human.class.getMethod("study",String.class,Integer.class);
     * 输出结果：  Assert.assertEquals("java.lang.String#study:java.lang.String,java.lang.Integer", ReflectUtil.getSignature(study));
     *
     * 输入示例：   Method humnan_getIds = Human.class.getMethod("getIds");
     * 输出结果：   Assert.assertEquals("java.util.List#getIds",ReflectUtil.getSignature(humnan_getIds));
     *
     * 输入示例：    Method student_getIds = Student.class.getMethod("getIds");
     * 输出结果：    Assert.assertEquals("java.util.ArrayList#getIds",ReflectUtil.getSignature(student_getIds));
     * @author: Goat
     * @Date:  2019年12月5日10:09:07
     */
    public static String getSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        Class<?> returnType = method.getReturnType();
        if (returnType != null) {
            sb.append(returnType.getName()).append('#');
        }
        sb.append(method.getName());
        Class<?>[] parameters = method.getParameterTypes();
        for (int i = 0; i < parameters.length; i++) {
            sb.append((i == 0)? ':':',');
            sb.append(parameters[i].getName());
        }
        return sb.toString();
    }
}
