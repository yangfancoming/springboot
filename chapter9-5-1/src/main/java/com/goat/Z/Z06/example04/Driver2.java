package com.goat.Z.Z06.example04;

import com.goat.Z.Z06.example03.Car;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: ②Setter传递依赖对象。
 * @ author  山羊来了
 * @ date 2019/5/6---13:42
 */
public class Driver2 {
    private Car car;
    public void setCar(Car car){
        this.car = car;
    }
    public void drive(){
        this.car.run();
    }
}
