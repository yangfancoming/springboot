package com.goat.Z.Z06.example03;


/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---13:28
 */
public class Driver {

    // 让Driver类依赖一个Car这个接口
    public void drive(Car car){
        car.run();
    }

}
