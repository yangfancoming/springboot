package com.goat.B.B02.item06;


public class Decorator extends Drink {

	private Drink obj;
	
	public Decorator(Drink obj) {
		this.obj = obj;
	}
	
	@Override
	public float cost() {
		return getPrice() + obj.cost();
	}
	
	@Override
	public String getDes() {
		return des + " " + getPrice() + " && " + obj.getDes();
	}
	
	

}
