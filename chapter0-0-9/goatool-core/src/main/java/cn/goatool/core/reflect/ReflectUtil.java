package cn.goatool.core.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;


public class ReflectUtil {



    /**
     * 获取指定Class对象的 所有的构造函数(public，protected，default(package)access和private)
     *  查找clazz的无参构造方法，通过反射遍历所有构造方法，过滤出构造参数集合长度为0的。
     */
    public static Constructor<?> getDefaultConstructor(Class<?> clazz) {
        // 取出所有构造函数 (public，protected，default(package)access和private)
        Constructor<?>[] consts = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : consts) {
            // 将无参构造函数保存起来 (只有默认构造函数没有参数)
            if (constructor.getParameterTypes().length == 0) {
                return constructor;
            }
        }
        return null;
    }

    /**
     * 为每个方法生成唯一签名，并记录到uniqueMethods集合中
     * @param uniqueMethods  记录方法签名map集合
     * @param methods  带生成签名的方法数组
     * 输入示例：
     * 0 = {Method@846} "public java.util.List cn.goatool.core.reflect.Student.getIds()"  --- 桥接方法会被过滤掉
     * 1 = {Method@847} "public java.util.ArrayList cn.goatool.core.reflect.Student.getIds()"
     * 2 = {Method@848} "public java.lang.String cn.goatool.core.reflect.Student.study(java.lang.String,java.lang.Integer)"
     * 3 = {Method@849} "public void cn.goatool.core.reflect.Student.eat()"
     * 输出结果：
     * "void#eat" -> {Method@849} "public void cn.goatool.core.reflect.Student.eat()"
     * "java.lang.String#study:java.lang.String,java.lang.Integer" -> {Method@848} "public java.lang.String cn.goatool.core.reflect.Student.study(java.lang.String,java.lang.Integer)"
     * "java.util.ArrayList#getIds" -> {Method@847} "public java.util.ArrayList cn.goatool.core.reflect.Student.getIds()"
     */
    public static Map<String, Method> addUniqueMethods(Map<String, Method> uniqueMethods, Method[] methods) {
        for (Method currentMethod : methods) {
            if (!currentMethod.isBridge()) {
                //得到方法签名 格式为：方法返回参数#方法名:参数名 ps：多个参数用,分割 签名样例:String#getName:User
                String signature = getSignature(currentMethod);
                //如果签名存在，则不做处理，表示子类已经覆盖了该方法。
                //如果签名不存在，则将签名作为Key,Method作为value 加入map
                if (!uniqueMethods.containsKey(signature)) {
                    uniqueMethods.put(signature, currentMethod);
                }
            }
        }
        return uniqueMethods;
    }

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
        // 获取方法返回值类型
        Class<?> returnType = method.getReturnType();
        if (returnType != null) {
            sb.append(returnType.getName()).append('#');
        }
        // 追加方法名
        sb.append(method.getName());
        Class<?>[] parameters = method.getParameterTypes();
        for (int i = 0; i < parameters.length; i++) {
            sb.append((i == 0)? ':':',');
            // 追加参数名
            sb.append(parameters[i].getName());
        }
        return sb.toString();
    }
}
