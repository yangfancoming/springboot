package com.goat.Z.Z06.example04;

import com.goat.Z.Z06.example03.Car;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: ①构造函数传递依赖对象。
 * @ author  山羊来了
 * @ date 2019/5/6---13:42
 */
public class Driver1 {
    private Car car;
    Driver1(Car car){
        this.car = car;
    }
    public void drive(){
        this.car.run();
    }
}
