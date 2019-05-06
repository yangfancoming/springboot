package com.goat.game;

import com.goat.game.constant.Suit;
import com.goat.game.hero.BS;
import com.goat.game.hero.Hero;
import com.goat.game.hero.ZYZ;
import com.goat.game.manager.MyGM;
import com.goat.game.poker.Pocker;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
        System.out.println(values);

        for (Suit s: values){
            System.out.println(s.name() + "-------" + s.value);
        }
    }

    public static void main(String[] args) {
        MyGM.createPoker(); // 产牌
        MyGM.flushPockes(); // 洗牌
        System.out.println(MyGM.pockers); // 查看 牌位

        //  洗牌后 按照花色分组  查看牌位
        Map<Suit, List<Pocker>> collect = MyGM.pockers.stream().collect(Collectors.groupingBy(Pocker::getSuit));
        System.out.println(collect);


        // 创建 玩家集合
        List<Hero> heroes = new LinkedList<>();
        heroes.add(new ZYZ());
        heroes.add(new BS());

        MyGM.dealPockes(heroes,4);// 给所有玩家发牌
        System.out.println(heroes);
    }


}
