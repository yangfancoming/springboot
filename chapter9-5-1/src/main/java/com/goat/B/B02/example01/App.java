package com.goat.B.B02.example01;

import com.goat.B.B02.example01.base.IRole;
import com.goat.B.B02.example01.equip.Bow;
import com.goat.B.B02.example01.equip.Shoe;
import com.goat.B.B02.example01.equip.Sword;
import com.goat.B.B02.example01.equip.Wand;
import com.goat.B.B02.example01.role.Mage;
import com.goat.B.B02.example01.role.Sagittary;
import com.goat.B.B02.example01.role.Warrior;
import org.junit.Test;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 抽象类 + 接口 模式
 * @ author  山羊来了
 * @ date 2019/4/26---15:07
 */
public class App {

    @Test
    public void test(){
        //创建法师
        IRole mage = new Mage();
        mage = new Shoe(mage);//鞋子
        mage = new Bow(mage);//弓
        mage = new Wand(mage);//法杖
        pringMsg(mage);
    }

    @Test
    public void test1(){
        //创建弓箭手
        IRole sagittary = new Sagittary();
        sagittary = new Shoe(sagittary);//鞋子
        sagittary = new Bow(sagittary);//弓
        pringMsg(sagittary);
    }

    @Test
    public void test2(){
        //创建战士
        IRole warrior = new Warrior();
        warrior = new Shoe(warrior);//鞋子
        warrior = new Sword(warrior);//剑
        pringMsg(warrior);
    }

    private void pringMsg (IRole role){
        System.out.println("角色描述：" + role.getDescribe());
        System.out.println("防御力：" + role.getDefense());
        System.out.println("攻击力：" + role.getPower());
    }
}
