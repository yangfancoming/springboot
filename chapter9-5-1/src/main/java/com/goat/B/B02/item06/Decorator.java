package com.goat.B.B02.item06;


public class Decorator extends Drink {

    // 装饰者 持有 被装饰者的引用
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
