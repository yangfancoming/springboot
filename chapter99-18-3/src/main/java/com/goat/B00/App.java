package com.goat.B00;

import com.goat.model.Car;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/15---19:54
 */
public class App {

    @Test
    public void test(){
//        Car car = new Car("BMW","white",120); // false
                Car car = new Car(); // true
        boolean b = checkObjAllFieldsIsNull(car);
        System.out.println(b);
    }


    /**
     * @Description: 检测对象的所有属性是否都为空(只检测包装类型属性)
     * @author fan.yang
     * @date 2019年7月15日20:00:03
     * @param object  待校检对象
     * @return 属性全 null 返回 true  否则返回 false
     */
    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
