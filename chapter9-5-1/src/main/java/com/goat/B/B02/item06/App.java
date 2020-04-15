package com.goat.B.B02.item06;

import com.goat.B.B02.item06.A.DeCaf;
import com.goat.B.B02.item06.A.LongBlack;
import com.goat.B.B02.item06.B.Chocolate;
import com.goat.B.B02.item06.B.Milk;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 64274 on 2019/7/16.
 * @ Description: 这里说白了 就是对象的层层嵌套！
 * @ author  山羊来了
 * @ date 2019/7/16---20:05
 */
public class App {

    @Test
    public void test(){
        // 创建黑咖啡
        Drink coffee = new LongBlack();
        System.out.println(coffee.cost());
        System.out.println(coffee.des);
        // 使用牛奶装饰
        Drink coffeeMilk = new Milk(coffee);
        System.out.println("coffeeMilk " + coffeeMilk.cost());
        System.out.println("coffeeMilk  =" + coffeeMilk.des);
        Assert.assertNotEquals(coffee,coffeeMilk);
        // 再使用巧克力装饰
        Drink coffeeMC = new Chocolate(coffeeMilk);
        System.out.println("coffeeMC" + coffeeMC.cost());
        System.out.println("coffeeMC  = " + coffeeMC.des);
        Assert.assertNotEquals(coffeeMilk,coffeeMC);
    }

    @Test
    public void test2(){
        Drink order = new DeCaf();
        System.out.println(order.cost());
        System.out.println(order.des);

        order = new Milk(order);
        System.out.println("order  =" + order.cost());
        System.out.println("order " + order.des);

        order = new Milk(order);
        System.out.println("order  =" + order.cost());
        System.out.println("order " + order.des);

//        order = new Chocolate(order);
//
//        System.out.println("order" + order.cost());
//        System.out.println("order  = " + order.getDes());
    }


}
