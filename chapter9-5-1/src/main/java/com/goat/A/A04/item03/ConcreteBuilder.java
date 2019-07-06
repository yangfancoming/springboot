package com.goat.A.A04.item03;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: 具体建造者(服务员)
 * @ author  山羊来了
 * @ date 2019/7/6---16:20
 */

public class ConcreteBuilder extends Builder{

    private Product product;
    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    Product build() {
        return product;
    }

    @Override
    Builder bulidA(String mes) {
        product.setBuildA(mes);
        return this;
    }

    @Override
    Builder bulidB(String mes) {
        product.setBuildB(mes);
        return this;
    }

    @Override
    Builder bulidC(String mes) {
        product.setBuildC(mes);
        return this;
    }

    @Override
    Builder bulidD(String mes) {
        product.setBuildD(mes);
        return this;
    }
}