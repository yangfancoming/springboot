package summary;


import org.testng.annotations.Test;

/**
     * @Description: 功能描述：( 多线程 龟兔赛跑 来演示 线程常用方法 )
     * @author: 杨帆
int getPriority() 　 获取线程优先级  线程默认优先级是5   范围 0 - 10
public static final int MAX_PRIORITY 10
public static final int MIN_PRIORITY 1
public static final int NORM_PRIORITY 5

void interrupt()　　中断线程。
线程通信：继承Object方法　　void notify()         void wait()
     * @Return:
     * @Date:   2018/8/29
*/

public class TestNG {

     class Mythread extends Thread {
         @Override
         public void run()  {
             for (int i = 0; i < 100; i++) {
                 System.out.println("Mythread.................." + i);
             }
         }
    }

    /**
         * @Description: 功能描述： 常用方法示例
         * @author: 杨帆
         * @Date:   2018/8/29
    */
    @Test
    public void methods(){
        Mythread t = new Mythread();
        t.setName("王二小"); // 改变线程名称
        System.out.println(t.getName()); // 返回该线程的名称。
        System.out.println(t.getPriority());  // 获取线程优先级
        System.out.println(t.isDaemon()); // 测试该线程是否为守护线程。
        t.setPriority(1);  //  更改线程的优先级。
        System.out.println(t.getPriority());
        //t1.setDaemon(true);  // 将该线程标记为守护线程或用户线程。
    }

    /**
         * @Description: 功能描述：测试线程和主线程 均100次随机正常执行
         * @author: 杨帆
         * @Date:   2018/8/29
    */
    @Test
    public void test()  {
        Mythread t = new Mythread();
        t.start();
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName()+ i);
        }
    }

    /**
         * @Description: 功能描述：join() 方法演示
     * 主线程 在执行到 i==30 时  t 线程 抢入 直到 t 线程执行结束后  主线程继续执行
         * @author: 杨帆
         * @Date:   2018/8/29
    */
    @Test
    public void join() throws InterruptedException {
        Mythread t = new Mythread();
        t.start();
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName()+ i);
            if(i == 30){
                t.join(); // t 线程 抢入
            }
        }
        System.out.println(t.isAlive());// false  线程死亡  因为只有 t 线程执行完毕死亡后  主线程才能开始继续执行
    }
    /**
     * @Description: 功能描述：yield() 方法演示
     * 主线程 在执行到 i%10 == 0 时 主线程让步 这样一来 t 线程就有很大几率抢到执行权
     * 多次运行测试代码 可以发现  主线程每次执行到10整数倍时 很大几率可以看到 t 线程执行
     * @author: 杨帆
     * @Date:   2018/8/29
     */
    @Test
    public void yield()  {
        Mythread t = new Mythread();
        t.start();
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName()+ i);
            if(i%10 == 0){
                Thread.currentThread().yield();
            }
        }

    }

    // sleep  当前线程 进入睡眠状态
    @Test
    public void sleep() throws InterruptedException {
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName()+ i);
            if(i%10 == 0){
                Thread.currentThread().sleep(500);
            }
        }
    }

    /**
     * @Description: 功能描述：setPriority() 方法演示
     * 可以看到  1.设置 t 线程的优先级为最高   2.设置主线程的优先级为最低    然后测试 会明显的发现  t 线程 优先执行
     *
     * @author: 杨帆
     * @Date:   2018/8/29
     */
    @Test
    public void setPriority()   {
        Mythread t = new Mythread();
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName()+ i +"----" + Thread.currentThread().getPriority());
        }
        System.out.println(t.isAlive());// false  线程死亡  因为只有 t 线程执行完毕死亡后  主线程才能开始继续执行
    }

    //   根据上个方法 反过来测试 更明显的
    @Test
    public void setPriority1()   {
        Mythread t = new Mythread();
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        for (int i = 0; i < 100 ; i++) {
            System.out.println(Thread.currentThread().getName()+ i +"----" + Thread.currentThread().getPriority());
        }
        System.out.println(t.isAlive());// false  线程死亡  因为只有 t 线程执行完毕死亡后  主线程才能开始继续执行
    }
}
