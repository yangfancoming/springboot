package com.goat.B.B07.item03;

/**
 * Created by 64274 on 2019/10/15.
 *
 * @ Description: 所有具体享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态
 * @ author  山羊来了
 * @ date 2019/10/15---17:07
 */
public abstract class Flyweight {

    //内部状态
    public String in_trinsic;

    //外部状态
    protected final String ex_trinsic;

    //要求享元角色必须接受外部状态
    public Flyweight(String extrinsic) {
        this.ex_trinsic = extrinsic;
    }

    //定义业务操作
    public abstract void operate(int extrinsic);

}