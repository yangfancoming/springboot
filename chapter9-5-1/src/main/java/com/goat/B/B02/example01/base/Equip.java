package com.goat.B.B02.example01.base;

/**
 * Created by 64274 on 2019/4/26.
 *
 * @ Description:   装饰者：装备抽象类   装饰者(游戏装备)持有被装饰者(游戏角色)的引用！！！
 * @ author  山羊来了
 * @ date 2019/4/26---15:06
 */

public abstract class Equip implements IRole {
    protected IRole role;
}