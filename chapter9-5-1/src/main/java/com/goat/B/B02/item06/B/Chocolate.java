package com.goat.B.B02.item06.B;

import com.goat.B.B02.item06.Decorator;
import com.goat.B.B02.item06.Drink;

public class Chocolate extends Decorator {

	public Chocolate(Drink obj) {
		super(obj);
		setDes("Chocolate");
		setPrice(3.0f);
	}

}
