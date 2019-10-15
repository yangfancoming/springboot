package com.goat.B.B07.item02;

public class ConcreteFlyweight extends Flyweight {

    private Character intrinsicState;

	public ConcreteFlyweight(Character state){
        this.intrinsicState = state;
	}
	
	@Override
    public void operation(String state) {
		System.out.print( "\n Intrinsic State = " + intrinsicState + ", Extrinsic State = " + state);
	}
}
