package com.goat.game.constant;

/**
 * Created by 64274 on 2019/5/7.
 *
 * @ Description: 卡牌名称枚举类
 * @ author  山羊来了
 * @ date 2019/5/7---11:04
 */
public enum Name {

    /* 基本牌 */
    杀(1),闪(2),药(3),

    /* 锦囊牌 */
    手捧雷(10),
    休养生息(20),
    万箭齐发(30),
    烽火狼烟(40),
    五谷丰登(50),
    决斗(60),
    借刀杀人(70),
    画地为牢(80),
    探囊取物(90),
    釜底抽薪(100),
    无中生有(110),
    无懈可击(120),

    /* 防御马 */
    忽雷驳(11),
    摄影(21),
    追风(31),

    /* 进攻马 */
    的卢(41),
    乌雅(51),
    赤兔(61),

    /* 防具 */
    玉如意(71),

    /* 武器 */
    鱼肠剑(81),
    芦叶枪(91),
    虎符(101),
    博浪锤(111),
    狼牙棒(121),
    龙鳞刀(131),
    霸王弓(141),
    盘龙棍(151),
    ;

    public int value;

    Name(int value){
        this.value = value;
    }
}
