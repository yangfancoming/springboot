package com.goat.A.A04.item02;

/**
 * Created by 64274 on 2019/7/6.
 *
 * @ Description: 具体建造者(工人)
 * @ author  山羊来了
 * @ date 2019/7/6---16:17
 */
public class ConcreteBuilder extends Builder{

    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    void bulidA() {
        product.setBuildA("地基");
    }

    @Override
    void bulidB() {
        product.setBuildB("钢筋工程");
    }

    @Override
    void bulidC() {
        product.setBuildC("铺电线");
    }

    @Override
    void bulidD() {
        product.setBuildD("粉刷");
    }

    @Override
    Product getProduct() {
        return product;
    }
}