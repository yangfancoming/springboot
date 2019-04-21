
package com.goat.A.A03.example01;

import org.junit.Test;


public class Minister {

    /** 可以看到 for循环 输出的 emperor 地址都是一样的 */
    @Test
    public void test(){
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
            System.out.println(emperor);
        }
    }

    /** 可以看到 for循环 输出的 emperor 地址都是一样的  由于是天然的线程安全 所以在多线程的情况下 该单例也是安全的*/
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Emperor instance = Emperor.getInstance();
                System.out.println(instance);
            },String.valueOf(i)).start();
        }
    }

}
