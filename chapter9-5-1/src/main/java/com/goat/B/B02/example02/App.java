package com.goat.B.B02.example02;

import com.goat.B.B02.example02.equip.ArmEquip;
import com.goat.B.B02.example02.equip.ShoeEquip;
import com.goat.B.B02.example02.gem.BlueGemDecorator;
import com.goat.B.B02.example02.gem.RedGemDecorator;
import com.goat.B.B02.example02.gem.YellowGemDecorator;
import org.junit.Test;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 双接口 模式
 * @ author  山羊来了
 * @ date 2019/4/29---9:41
 */
public class App {

    public static void main(String[] args) {
        // 一个镶嵌2颗红宝石，1颗蓝宝石的靴子
        System.out.println(" 一个镶嵌2颗红宝石，1颗蓝宝石的靴子");
        IEquip equip = new RedGemDecorator(new RedGemDecorator(new BlueGemDecorator(new ShoeEquip())));
        System.out.println("攻击力  : " + equip.caculateAttack());
        System.out.println("描述 :" + equip.description());
        System.out.println("-------");
        // 一个镶嵌1颗红宝石，1颗蓝宝石的武器
        System.out.println(" 一个镶嵌1颗红宝石，1颗蓝宝石,1颗黄宝石的武器");
        equip = new RedGemDecorator(new BlueGemDecorator(new YellowGemDecorator(new ArmEquip())));
        System.out.println("攻击力  : " + equip.caculateAttack());
        System.out.println("描述 :" + equip.description());
        System.out.println("-------");
    }

    @Test
    public void test(){
        // 一个镶嵌1颗红宝石，1颗蓝宝石的武器
        System.out.println(" 一个镶嵌1颗红宝石，1颗蓝宝石,1颗黄宝石的武器");
        IEquip equip = new RedGemDecorator(new BlueGemDecorator(new YellowGemDecorator(new ArmEquip())));
        System.out.println("攻击力  : " + equip.caculateAttack());
        System.out.println("描述 :" + equip.description());
        System.out.println("-------");
    }

    @Test
    public void test1(){
        // 一个镶嵌1颗红宝石，1颗蓝宝石的武器
        System.out.println(" 一个镶嵌1颗红宝石，1颗蓝宝石,1颗黄宝石的武器");
        IEquip armEquip = new ArmEquip(); // 创建 一个 武器
        IEquip yellowGemDecorator = new YellowGemDecorator(armEquip); // 给武器装饰  黄宝石
        IEquip blueGemDecorator = new BlueGemDecorator(yellowGemDecorator); // 给武器装饰  蓝宝石
        IEquip redGemDecorator = new RedGemDecorator(blueGemDecorator); // 给武器装饰  红宝石
        IEquip equip = new RedGemDecorator(redGemDecorator); // 给武器装饰  红宝石
        System.out.println("攻击力  : " + equip.caculateAttack());
        System.out.println("描述 :" + equip.description());
        System.out.println("-------");
    }
}
