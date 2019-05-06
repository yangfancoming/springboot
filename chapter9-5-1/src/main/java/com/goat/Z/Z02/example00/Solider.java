package com.goat.Z.Z02.example00;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---12:00
 */
public class Solider {

    private AbstractGun gun; //此处的AbstractGun gun 是父类出现的地方，子类可以出现 体现在传给它的实际参数类型可以是Machinegun或者Handgun任一种类型，并且都不会出错

    public void setGun(AbstractGun gun){
        this.gun = gun;
    }

    public void kill(){
        this.gun.shoot();
    }
}
