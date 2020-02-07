package com.goat.B.B02.item06;

import com.goat.B.B02.item06.A.DeCaf;
import com.goat.B.B02.item06.A.LongBlack;
import com.goat.B.B02.item06.B.Chocolate;
import com.goat.B.B02.item06.B.Milk;
import org.junit.Test;

/**
 * Created by 64274 on 2019/7/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/16---20:05
 */
public class App {

    @Test
    public void test(){

        Drink order = new LongBlack();
        System.out.println(order.cost());
        System.out.println(order.getDes());

        order = new Milk(order);
        System.out.println("order  =" + order.cost());
        System.out.println("order " + order.getDes());

        order = new Chocolate(order);

        System.out.println("order" + order.cost());
        System.out.println("order  = " + order.getDes());

    }

    @Test
    public void test2(){
        Drink order = new DeCaf();
        System.out.println(order.cost());
        System.out.println(order.getDes());

        order = new Milk(order);
        System.out.println("order  =" + order.cost());
        System.out.println("order " + order.getDes());

        order = new Milk(order);
        System.out.println("order  =" + order.cost());
        System.out.println("order " + order.getDes());

//        order = new Chocolate(order);
//
//        System.out.println("order" + order.cost());
//        System.out.println("order  = " + order.getDes());
    }


}
