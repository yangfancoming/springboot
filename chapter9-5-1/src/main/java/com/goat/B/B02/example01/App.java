package com.goat.B.B02.example01;

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
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/26---15:07
 */
public class App {

    private void pringMsg (IAttribute attribute){
        System.out.println("角色描述："+attribute.getDescribe());
        System.out.println("防御力："+attribute.getDefense());
        System.out.println("攻击力："+attribute.getPower());
    }

    /**
     角色描述：法师,鞋子,法杖
     防御力：77.0
     攻击力：140.0
     角色描述：弓箭手,鞋子弓箭,
     防御力：85.0
     攻击力：90.0
     角色描述：武士,鞋子,剑
     防御力：110.0
     攻击力：70.0
    */

    @Test
    public void testDecorator(){
        //创建法师
        IAttribute attribute = new Mage();
        attribute = new Shoe(attribute);//鞋子
        attribute = new Wand(attribute);//法杖
        pringMsg(attribute);

        //创建弓箭手
        IAttribute attribute1 = new Sagittary();
        attribute1 = new Shoe(attribute1);//鞋子
        attribute1 = new Bow(attribute1);//弓
        pringMsg(attribute1);

        //创建战士
        IAttribute attribute2 = new Warrior();
        attribute2 = new Shoe(attribute2);//鞋子
        attribute2 = new Sword(attribute2);//剑
        pringMsg(attribute2);
    }

}
