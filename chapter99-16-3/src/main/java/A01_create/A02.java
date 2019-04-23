package A01_create;


import org.junit.Test;

/**
     * @Description:  （多线程 演示龟兔赛跑）
     * @author: 杨帆
     * @Date:   2018/8/29
*/

public class A02 {

     class Rabbit extends Thread { //演示 继承 Thread 方式
         @Override
         public void run()  {
             for (int i = 0; i < 100; i++) {
                 System.out.println("Rabbit.................." + i);
             }
         }
    }
    class Tortoise implements Runnable  { //演示 实现 Runnable 方式
        @Override
        public void run()  {
            for (int i = 0; i < 100; i++) {
                System.out.println("Tortoise.................." + i);
            }
        }
    }

    // 使用匿名类方式
    @Test
    public void test1(){
        new Rabbit().start();
        new Tortoise().run();
    }

    /**
         * @Description:  使用静态代理方式 创建线程
         * @author: 杨帆
         * @Param:   1. 真实角色和代理角色 实现同一个接口
         * @Return:  2. 代理角色包含真实角色的引用
         * @Date:   2018/8/31
    */
    @Test
    public void test2(){
        Rabbit rabbit = new Rabbit(); // 真实角色
        Thread temp =new Thread(rabbit); // 代理角色
        temp.start();

        Tortoise tortoise = new Tortoise();
        Thread temp2 =new Thread(tortoise);
        temp2.start();
    }
}
