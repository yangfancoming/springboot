package com.goat.game;

import com.goat.game.constant.Suit;
import com.goat.game.hero.Hero;
import com.goat.game.hero.XY;
import com.goat.game.hero.ZYZ;
import com.goat.game.manager.MyGM;
import com.goat.game.poker.Card;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---16:01
 */
public class App {

    @Test
    public void test1(){
        Suit[] values = Suit.values();
        for (Suit s: values){
            System.out.println(s.name() + "-------" + s.value);
        }
    }

    @Test
    public void test2(){
        List<Card> poker = MyGM.createPoker(2);// 产牌
        System.out.println(poker);
        List<Card> ending = MyGM.ending(poker); // 完成卡牌最后拼装
        System.out.println(ending);
    }

    public static void main(String[] args) throws IOException {
        MyGM.createCards(); // 产牌
        MyGM.flushPockes(100); // 洗牌
        System.out.println(MyGM.pockers); // 查看 牌位

        // 创建 玩家集合
        List<Hero> heroes = new LinkedList<>();
        heroes.add(new ZYZ());
        heroes.add(new XY());

        // 给所有玩家发牌
        MyGM.dealPockes(heroes,4);
        System.out.println(heroes);

        //  洗牌后 按照花色分组  查看牌位
//        Map<Boolean, List<Card>> collect = MyGM.pockers.stream().collect(Collectors.groupingBy(Card::getAP));
//        System.out.println(collect);

        for (Hero hero:heroes){
            System.out.println(hero.getName()+ hero.getPlayerCards());
        }

    }

    @Test
    public void test3() throws IOException {
        int i = new Random().nextInt(9);
        String in = "" ;
        do {
            if (i%2==0){
                System.out.println("项羽先出牌：");
                in = new BufferedReader(new InputStreamReader(System.in)).readLine();// 得到命令行输入
            }
        } while (!in.equals("exit"));
    }

}
