package com.goat.Z.Z06.item02;



/**
 * Created by 64274 on 2019/5/6.
    演示接口的演化过程
 * @ author  山羊来了
 * @ date 2019/5/6---13:27
 */

public class App {

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.drive(new Bmw()); // 此处不再 需要修改了
        driver.drive(new Benz()); // 此处不再 需要修改了
    }
}