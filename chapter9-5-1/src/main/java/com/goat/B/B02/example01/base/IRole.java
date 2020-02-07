package com.goat.B.B02.example01.base;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description: 被装饰者  游戏玩家接口
 * @ author  山羊来了
 * @ date 2019/4/26---15:04
 */
public interface IRole {

    //获取防御力
    float getDefense();

    //获取攻击力法
     float getPower();

    //获取描述
     String getDescribe();
}