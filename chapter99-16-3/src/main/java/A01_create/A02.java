package A01_create;


import org.junit.Test;

/**
     * @Description:  （多线程 演示龟兔赛跑）
     * @author: Goat
     * @Date:   2018/8/29
*/

public class A02 {

     static class Rabbit extends Thread { //演示 继承 Thread 方式
         @Override
         public void run()  {
             for (int i = 0; i < 20; i++) {
                 System.out.println("Rabbit.................." + i);
             }
         }
    }

    static class Tortoise implements Runnable  { //演示 实现 Runnable 方式
        @Override
        public void run()  {
            for (int i = 0; i < 20; i++) {
                System.out.println("Tortoise.................." + i);
            }
        }
    }

    /**
     * @Description:  使用静态代理方式 创建线程
     * @author: Goat
     * @Param:   1. 真实角色和代理角色 实现同一个接口
     * @Return:  2. 代理角色包含真实角色的引用
     * @Date:   2018/8/31
     */
    public static void test1(){
        Rabbit rabbit = new Rabbit(); // 真实角色
        Thread temp = new Thread(rabbit); // 代理角色
        temp.start();

        Tortoise tortoise = new Tortoise();
        Thread temp2 =new Thread(tortoise);
        temp2.start();
    }

    // 使用匿名类方式
    public static void test2(){
        new Rabbit().start();
        new Tortoise().run();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }



}
