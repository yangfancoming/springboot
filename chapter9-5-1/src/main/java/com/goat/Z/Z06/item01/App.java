package com.goat.Z.Z06.item01;

import org.junit.Test;

/**
 * Created by 64274 on 2019/5/6.
 * 实例类之间产生依赖所出现的问题
 * @ Description: 假如有一天Driver不开benz了，则此时代码要修改两处：
 *  1.Driver类中的参数 public void drive(Benz benz)
 *  2.App类中的调用参数  driver.drive(new BMW());
 * 因为Driver类和Benz类之间的紧耦合导致只是增加了一辆车就要修改Driver类和App类。因此正确的做法是让Driver类去依赖一个接口
 * @ author  山羊来了
 * @ date 2019/5/6---13:27
 */

public class App {

    Driver driver = new Driver();

    @Test
    public void test(){
        driver.drive(new Bmw()); //
//        driver.drive(new Benz());// 开奔驰则报错  需要修改
    }

}