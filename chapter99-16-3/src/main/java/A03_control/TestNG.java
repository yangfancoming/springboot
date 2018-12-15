package A03_control;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
     * @Description: 功能描述： 如何控制线程的执行顺序
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/4
*/

public class TestNG {

    Thread t1 = new Thread(()->System.out.println("t1"));
    Thread t2 = new Thread(()->System.out.println("t2"));
    Thread t3 = new Thread(()->System.out.println("t3"));

    // 线程 1 2 3 的执行顺序是随机的
    @Test
    public void test0(){
        t1.start();
        t2.start();
        t3.start();
    }
    // 线程 1 2 3 的执行顺序 是有顺序的！
    @Test
    public void test1() throws InterruptedException {
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
    }
    /**
         * @Description: 功能描述：线程 1 2 3 的执行顺序 是有顺序的！
         * @author: 杨帆
            newSingleThreadExecutor 返回一个包含单线程的Executor,将多个任务交给此Exector时，
            这个线程处理完一个任务后接着处理下一个任务，若该线程出现异常，将会有一个新的线程来替代。
         * @Date:   2018/9/4
    */
    @Test
    public void test2(){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        // 向线程池中提交
        pool.submit(t1);
        pool.submit(t2);
        pool.submit(t3);
        pool.shutdown(); // 关闭线程池
    }
}
