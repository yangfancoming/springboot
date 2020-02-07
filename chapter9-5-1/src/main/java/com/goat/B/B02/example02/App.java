package com.goat.B.B02.example02;

import com.goat.B.B02.example02.equip.ArmEquip;
import com.goat.B.B02.example02.equip.ShoeEquip;
import com.goat.B.B02.example02.gem.BlueGemDecorator;
import com.goat.B.B02.example02.gem.RedGemDecorator;
import com.goat.B.B02.example02.gem.YellowGemDecorator;
import org.junit.Test;

/**
 * Created by 64274 on 2019/4/29.
 * @ Description: 双接口 模式
 * @ author  山羊来了
 * @ date 2019/4/29---9:41
 */
public class App {

    @Test
    public void test(){
        // 红 + 红 + 蓝 + 黄 + 武器
        IEquip armEquip = new ArmEquip(); // 创建 一个 武器
        IEquip yellowGemDecorator = new YellowGemDecorator(armEquip); // 给武器装饰  黄宝石
        IEquip blueGemDecorator = new BlueGemDecorator(yellowGemDecorator); // 给武器装饰  蓝宝石
        IEquip redGemDecorator = new RedGemDecorator(blueGemDecorator); // 给武器装饰  红宝石
        IEquip equip = new RedGemDecorator(redGemDecorator); // 给武器装饰  红宝石
        System.out.println("攻击力  : " + equip.caculateAttack());
        System.out.println("描述 :" + equip.description());
    }

    @Test
    public void test1(){
        // 红 + 蓝 + 黄 + 武器
        IEquip equip = new RedGemDecorator(new BlueGemDecorator(new YellowGemDecorator(new ArmEquip())));
        System.out.println("攻击力  : " + equip.caculateAttack());
        System.out.println("描述 :" + equip.description());
    }

    @Test
    public void test2(){
        // 红 + 红 + 蓝 + 鞋子
        IEquip equip = new RedGemDecorator(new RedGemDecorator(new BlueGemDecorator(new ShoeEquip())));
        System.out.println("攻击力  : " + equip.caculateAttack());
        System.out.println("描述 :" + equip.description());
    }

}
