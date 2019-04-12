package com.goat.B.B04;

import org.junit.Test;

/**
 * Created by 64274 on 2019/4/12.
 *
 * @ Description: 客户端
 * @ author  山羊来了
 * @ date 2019/4/12---16:06
 */
public class App {

    @Test
    public void test(){
        Computer computer = new Computer();
        computer.start();
        System.out.println("---------------------------");
        computer.shutDown();
    }
}
