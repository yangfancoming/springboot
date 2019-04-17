package com.goat.restructure;


import com.goat.restructure.model.Bar;
import com.goat.restructure.model.Foo;
import org.junit.Test;

public class App {


    @Test
    public void test() {
        // doit 如何将  test1 和 test2 方法 重构成一个方法

    }

    public void test1(Bar bar){
        System.out.println(bar.getId());
        System.out.println(bar.getBarName());
    }
    public void test1(Foo foo){
        System.out.println(foo.getId());
        System.out.println(foo.getFooName());
    }


}
