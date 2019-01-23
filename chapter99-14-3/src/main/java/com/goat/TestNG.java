package com.goat;


import com.goat.annotation.Column;
import com.goat.annotation.Init;
import com.goat.annotation.Table;
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
        for (int i = 0; i < allfields.length; i++) {
            Column column = allfields[i].getDeclaredAnnotation(Column.class);
            if(column != null){
                System.out.println(column.col_name());
            }
        }

        for (int i = 0; i < allfields.length; i++) {
            Init init = allfields[i].getDeclaredAnnotation(Init.class);
            if(init != null){
                System.out.println(init.value());
            }
        }
        Table annotation = aClass.getAnnotation(Table.class);
        System.out.println(annotation.tb_name());
    }



}
