package com.goat.B.B02.item06;


public class Decorator extends Drink {

    private Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    @Override
    public float cost() {
        float cost = obj.cost();
        return price + cost;
    }
}
