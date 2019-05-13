package com.goat.B.B07.item02;


public class App {

    private static FlyweightFactory factory = new FlyweightFactory();

    static public void main(String[] args){

		Flyweight fly = factory.factory('a');
		fly.operation("First Call");
		
		fly = factory.factory('b');
		fly.operation("Second Call");
		
		fly = factory.factory('a');
		fly.operation("Third Call");

        fly = factory.factory('e');
        fly.operation("Third Call");
		
		// intrinsic Flyweight
		factory.checkFlyweight();
	} 
}
