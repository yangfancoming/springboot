package com.goat;


import com.goat.annotation.Column;
import com.goat.annotation.Init;
import com.goat.annotation.Table;
import com.goat.annotation.Validate;
import com.goat.entity.User;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class TestNG  {

    @Test
    public void test0() throws ClassNotFoundException {
        // 反射拿到 class文件 字节码
        Class<?> aClass = Class.forName("com.goat.entity.User");
        // 拿到类成员属性
        Field[] allfields = aClass.getDeclaredFields();  // 该方法 可以获取类中的所有属性   无论公有还是私有
        // 遍历 User 类中的所有字段属性 拿到注解获取 name 值
        for (Field field:allfields){
            Column column = field.getDeclaredAnnotation(Column.class);
            if(column != null){
                System.out.println(column.col_name());
            }
        }

        for (Field field:allfields){
            Init init = field.getDeclaredAnnotation(Init.class);
            if(init != null){
                System.out.println(init.value());
            }
        }
        Table annotation = aClass.getAnnotation(Table.class);
        System.out.println(annotation.tb_name());
    }

    @Test
    public void test1() {
        // 反射拿到 class文件 字节码
        User user = new User();
        user.setUserName("");
        user.setPhone("111");
        Field[] allfields = User.class.getDeclaredFields(); // 该方法 可以获取类中的所有属性   无论公有还是私有
        // 遍历 User 类中的所有字段属性 拿到注解获取 name 值
        for (Field field:allfields){
            Validate validate = field.getDeclaredAnnotation(Validate.class);
            if(field.getName().equals("sex")){
                if (validate.isNotNull()) {
                    System.out.println("！！用户名可空校验不通过：不可为空！！");
                }else {
                    System.out.println("用户名可空校验通过：可以为空");
                }
                if (user.getUserName().length() < validate.min()) {
                    System.out.println("！！用户名最小长度校验不通过！！");
                }
                else{
                    System.out.println("用户名最小长度校验通过");
                }

                if (user.getUserName().length() > validate.max()){
                    System.out.println("！！用户名最大长度校验不通过！！");
                }
                else{
                    System.out.println("用户名最大长度校验通过");
                }
            }
        }
    }

}
