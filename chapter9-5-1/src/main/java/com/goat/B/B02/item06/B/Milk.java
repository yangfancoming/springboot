package com.goat.B.B02.item06.B;

import com.goat.B.B02.item06.Decorator;
import com.goat.B.B02.item06.Drink;


// 装饰者： 牛奶
public class Milk extends Decorator {

	public Milk(Drink obj) {
		super(obj);
        des = "牛奶";
        price = 2.0f;
	}

}
