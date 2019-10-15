package com.goat.B.B07.item03;

/**
 * Created by 64274 on 2019/10/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/15---17:08
 */
public class UnsharedConcreteFlyweight extends Flyweight {

    public UnsharedConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    @Override
    public void operate(int extrinsic) {
        System.out.println("不共享的具体Flyweight:" + extrinsic);
    }

}