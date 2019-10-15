package com.goat.B.B07.item03;

/**
 * Created by 64274 on 2019/10/15.
 *
 * @ Description: 继承Flyweight超类或实现Flyweight接口，并为其内部状态增加存储空间
 * @ author  山羊来了
 * @ date 2019/10/15---17:07
 */
public class ConcreteFlyweight extends Flyweight {

    //接受外部状态
    public ConcreteFlyweight(String extrinsic) {
        super(extrinsic);
    }

    //根据外部状态进行逻辑处理
    @Override
    public void operate(int extrinsic) {
        System.out.println("具体Flyweight:" + extrinsic);
    }

}