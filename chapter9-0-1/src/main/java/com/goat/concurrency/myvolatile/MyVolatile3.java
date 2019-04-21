package com.goat.concurrency.myvolatile;



/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: 证明 volatile 禁止指令重排
 * @ author  山羊来了
 * @ date 2019/4/21---17:09
 */
public class MyVolatile3 {

    public static void main(String[] args) {

        int x = 11; // 1
        int y = 12; // 2
        x = x + 5; // 3
        y = y * x; // 4

        System.out.println(y);
    }
    /**
     *  以上代码 经过编译器 指令重排后 可能的执行顺序：
     *  1.  1234
     *  2.  2134
     *  3.  1324
     *  不可能是 4 开头 因为指令重排 必须要考虑到 数据之间的依赖性
    */

}
