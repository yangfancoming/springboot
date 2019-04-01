package com.goat.C.C06.example00;

/**
 * Created by 64274 on 2019/4/1.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/1---13:38
 */
public class Test {


    public static void main(String[] args) {
        Barbecue barbecue = new Barbecue();
        Commond commond1 = new ChickenCommond(barbecue);
        Commond commond2 = new MuttonCommod(barbecue);
        Waiter waiter = new Waiter();
        waiter.addCommond(commond1);
        waiter.addCommond(commond2);
        waiter.Notify();
    }
}
