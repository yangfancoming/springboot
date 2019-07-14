package com.goat.B.B01.item01;



/**
 * Created by 64274 on 2019/7/14.
 *
 * @ Description:适配器：把源接口转换成目标接口
 * @ author  山羊来了
 * @ date 2019/7/14---11:33
 */
public class Adapter implements Target {

    //通过组合的方式实现注入
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee=adaptee;
    }

    @Override
    public void Request() {
        adaptee.SpecificRequest();
        System.out.println("被适配后的方法");
    }

}
