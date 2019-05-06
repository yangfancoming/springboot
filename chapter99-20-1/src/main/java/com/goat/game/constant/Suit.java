package com.goat.game.constant;

/**
 * Created by 64274 on 2018/9/11.
 *
 * @author 山羊来了
 * @Description: 扑克牌 花色  "黑桃","红桃","方块","梅花"
 * 红桃:H-Heart 桃心(象形),代表爱情.
 * 黑桃:S-Spade 橄榄叶(象形),代表和平.
 * 方块:D-Diamond 钻石(形同意合),代表财富.
 * 梅花:C-Club 三叶草(象形),代表幸运.
 * @date 2019年5月6日17:36:26
 */
public enum Suit {

//    Heart(0),Spade(1),Diamond(2),Club(3);
    红桃(0),黑桃(1),方块(2),梅花(3);

    public int value;

     Suit(int value){
        this.value = value;
    }

}
