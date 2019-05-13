package com.goat.B.B02.item04;


import com.goat.B.B02.item04.base.Pancake;
import com.goat.B.B02.item04.base.Roujiamo;
import com.goat.B.B02.item04.base.TornCake;
import com.goat.B.B02.item04.garnish.Egg;
import com.goat.B.B02.item04.garnish.Ham;
import org.junit.Test;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description:
 *  分为 主体（被装饰者） 和 配菜（装饰者）
 *  主体： 手抓饼 和 肉夹馍
 *  配菜： 鸡蛋 、 火腿 、 肉松 、 黄瓜丝
 *  根据 客户选择的主体和配菜  计算总价格。
 * @ author  山羊来了
 * @ date 2019/5/13---9:04
 */
public class App {


    @Test
    public void test() {
        Pancake tornCake = new TornCake();
        Pancake egg = new Egg(tornCake);
        Pancake ham = new Ham(egg);
        System.out.println(tornCake.getDesc() + tornCake.price());// 【手抓饼】4.0
        System.out.println(egg.getDesc() + egg.price());// 【手抓饼】煎蛋6.0
        System.out.println(ham.getDesc() + ham.price());// 【手抓饼】煎蛋火腿7.5
    }

    @Test
    public void test1() {
        Pancake roujiamo = new Roujiamo();
        Pancake egg = new Egg(roujiamo);
        Pancake ham = new Ham(egg);
        System.out.println(ham.getDesc() + ham.price());
    }
}
