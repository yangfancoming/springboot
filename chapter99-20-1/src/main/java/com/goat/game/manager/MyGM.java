package com.goat.game.manager;

import com.goat.game.constant.Constant;
import com.goat.game.constant.Suit;
import com.goat.game.hero.Hero;
import com.goat.game.poker.Card;

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

    public static LinkedList<Card> pockers = new LinkedList<>();

    /* 产牌  参数：产生几副牌 */
    public static List<Card> createPoker(Integer count){
        for (int i = 0; i < count; i++)
            createPoker();
        return pockers;
    }

    /* 由于 正常扑克是52张牌 两副牌是104张  英雄杀中是106张牌 因为：两副牌 多了3张牌 少了一张牌 */
    public static List<Card> ending(List<Card> pockers){
        pockers.remove(90); // 暂时先用 通过索引删除方式
//        pockers.remove(new Card(Suit.方块,Constant.face[12])); // 删除一个 方块 K   doit  这里按照元素 对象删除 为什么不行？ 需要 重写 equals 方法？
        pockers.add(new Card(Suit.红桃,Constant.face[11]));  // 增加一个 红桃 Q
        pockers.add(new Card(Suit.方块,Constant.face[4]));    // 增加一个 方块 5
        pockers.add(new Card(Suit.方块,Constant.face[11]));   // 增加一个 方块 Q
        return pockers;
    }
    /* 产牌  默认产生一副牌 */
    public static List<Card> createPoker(){
        for (Suit s: Suit.values()){
            for (String f: Constant.face)
                pockers.add(new Card(s,f));
        }
        return pockers;
    }

    /* 翻译牌  通过 花色 和 面值  查找出对应的 牌名称 */
    public static void translatePoker(List<Card> cards){

    }

    /* 洗牌 */
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

    /* 发牌  玩家集合 和 发牌数量 */
    public static void dealPockes(List<Hero> heroes,Integer count){
       for (Hero hero: heroes){
           LinkedList<Card> temp = new LinkedList<>();
           for (int i = 0; i < count; i++) {
               temp.add(pockers.pop());
           }
           hero.getHeroState().setPlayerCards(temp);
       }
    }
}
