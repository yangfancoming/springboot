package com.goat.B.B02.item06.B;

import com.goat.B.B02.item06.Decorator;
import com.goat.B.B02.item06.Drink;



// 装饰者： 巧克力
public class Chocolate extends Decorator {

	public Chocolate(Drink obj) {
		super(obj);
        des = "巧克力";
        price = 3.0f;
	}

}
