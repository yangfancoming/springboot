package com.goat.B.B07.test;

import java.util.HashMap;

public class FlyweightFactory {

    private HashMap map = new HashMap();

	public FlyweightFactory(){}
	
	public synchronized Flyweight factory(Character state){
		if ( map.containsKey( state ) ){
            return (Flyweight) map.get( state );
        }
        else{
			Flyweight fly = new ConcreteFlyweight( state );
            map.put( state , fly);
            return fly;
        }
	}
	
	public void checkFlyweight() {
        map.forEach((k,v)->System.out.println("\n 我是key："+ k + "------ 我是 value：" + v));
        System.out.println(map.size());
	}

}
