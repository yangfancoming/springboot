package com.goat.B.B01.item00;

/**
 * Created by 64274 on 2019/7/14.
 *
 * @ Description:适配器：把源接口转换成目标接口
 * @ author  山羊来了
 * @ date 2019/7/14---11:33
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void Request() {
        SpecificRequest();
        System.out.println("被适配后的方法");
    }

}
