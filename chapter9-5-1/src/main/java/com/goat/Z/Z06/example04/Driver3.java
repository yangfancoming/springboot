package com.goat.Z.Z06.example04;

import com.goat.Z.Z06.example03.Car;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: ③接口声明依赖对象，也叫接口注入。
 * @ author  山羊来了
 * @ date 2019/5/6---13:42
 */
public class Driver3 {
    public void drive(Car car){
        car.run();
    }
}
