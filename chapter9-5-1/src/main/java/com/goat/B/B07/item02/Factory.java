package com.goat.B.B07.item02;

import java.util.HashMap;

/**
 * Created by 64274 on 2019/5/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/13---13:27
 */
public abstract class Factory {

    private HashMap map = new HashMap();

    // 参数 state 是外部状态
    public Flyweight factory(Character state){
        if ( map.containsKey( state ) ){ // 返回已经存在的 实现类
            return (Flyweight) map.get( state );
        }

        Flyweight fly = new ConcreteFlyweight( state );
        map.put( state , fly);
        return fly; //如果不存在则 返回 新创建的实现类
    }

    public void checkFlyweight() {
        map.forEach((k,v)->System.out.println("\n I'm Key "+ k + "------ I'm Value" + v));
        System.out.println(map.size());
    }
}
