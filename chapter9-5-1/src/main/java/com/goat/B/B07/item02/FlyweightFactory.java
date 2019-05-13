package com.goat.B.B07.item02;

import java.util.HashMap;

public class FlyweightFactory {

    private HashMap map = new HashMap();

	public FlyweightFactory(){}
	
	public synchronized Flyweight factory(Character state){
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
