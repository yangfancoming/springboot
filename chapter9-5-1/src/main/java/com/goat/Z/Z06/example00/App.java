package com.goat.Z.Z06.example00;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: 实例类之间产生依赖所出现的问题
 * @ author  山羊来了
 * @ date 2019/5/6---13:26
 */

public class App {

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.drive(new Benz());
    }
}