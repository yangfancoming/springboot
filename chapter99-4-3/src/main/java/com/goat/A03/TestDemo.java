package com.goat.A03;


import org.junit.Test;

public class TestDemo {

    @Test
    public void test(){ // k = 10
        int k = 0;
        for(int i = 0;i<10;i++){
            k++;
        }
        System.out.println("k=" + k);
    }

    @Test
    public void test2(){ // k = 0
        int k = 0;
        for(int i = 0;i<10;i++){//  temp = i   i = i + 1  i = temp  +1是在赋值之前进行的  导致k变量永远为0
            k = k++;
        }
        System.out.println("k=" + k);
    }

}
