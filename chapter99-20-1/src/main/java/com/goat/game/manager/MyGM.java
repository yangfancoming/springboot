package com.goat.game.manager;

import com.goat.game.constant.Constant;
import com.goat.game.constant.Suit;
import com.goat.game.hero.Hero;
import com.goat.game.poker.Pocker;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---21:10
 */
public class MyGM {

    public static LinkedList<Pocker> pockers = new LinkedList<>();

    // 产牌
    public static void createPoker(){
        for (String f: Constant.face){
            for (Suit s: Suit.values()){
                pockers.add(new Pocker(f, s));
            }
        }
    }

    // 洗牌
    public static void flushPockes(){
        Random random=new Random();  //创建随机对象
        for(int i=0;i<100;i++){
            //随机产生两个索引值
            int a=random.nextInt(pockers.size());
            int b=random.nextInt(pockers.size());
            //根据索引值取出两张牌  并进行位置替换
            pockers.set(a, pockers.get(b));
            pockers.set(b, pockers.get(a));
        }
    }

    // 发牌  玩家集合 和 发牌数量
    public static void dealPockes(List<Hero> heroes,Integer count){
       for (Hero hero: heroes){
           LinkedList<Pocker> temp = new LinkedList<>();
           for (int i = 0; i < count; i++) {
               temp.add(pockers.pop());
           }
           hero.setPlayerPockers(temp);
       }
    }
}
