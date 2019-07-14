package com.goat.B.B01.item03;


import com.goat.B.B01.item02.AC220;
import com.goat.B.B01.item02.DC5;

/**
 * Created by 64274 on 2019/7/14.
 * 因为java单继承的缘故，Destination类必须是接口，
 * 以便于Adapter去继承Source并实现Destination，完成适配的功能，
 * 但这样就导致了Adapter里暴露了Source类的方法，使用起来的成本就增加了。
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/14---11:49
 */
public class App {

    public static void main(String[] args) {
        AC220 ac220 = new AC220();
        DC5 dc5 = new PowerAdapter(ac220);
        System.out.println("转换后"+dc5.output5V()+ "V");
    }
}
