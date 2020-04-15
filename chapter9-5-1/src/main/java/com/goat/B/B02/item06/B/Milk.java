package com.goat.B.B02.item06.B;

import com.goat.B.B02.item06.Decorator;
import com.goat.B.B02.item06.Drink;


public class Milk extends Decorator {

	public Milk(Drink obj) {
		super(obj);
        des = "Milk";
        price = 2.0f;
	}

}
