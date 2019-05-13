package com.goat.B.B02.item03;


import com.goat.B.B02.item03.garnish.Cucumber;
import com.goat.B.B02.item03.garnish.Egg;
import com.goat.B.B02.item03.garnish.Ham;
import com.goat.B.B02.item03.garnish.MeatFloss;
import com.goat.B.B02.item03.base.Pancake;
import com.goat.B.B02.item03.base.Roujiamo;
import com.goat.B.B02.item03.base.TornCake;
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
        Pancake tornCake = new TornCake();      //手抓饼基础价
        tornCake  = new Egg(tornCake);
        System.out.println(String.format("%s。  共计： ￥%s", tornCake.getDesc(), tornCake.price()));

        Pancake roujiamo = new Roujiamo();
        roujiamo = new Egg(roujiamo);
        roujiamo = new Ham(roujiamo);
        roujiamo = new MeatFloss(roujiamo);
        roujiamo = new Cucumber(roujiamo);
        System.out.println(String.format("%s。  共计：￥%s", roujiamo.getDesc(), roujiamo.price()));
    }

}
