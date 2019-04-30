package A02_lifecycle;


import org.junit.Test;

/**
     * @Description: 功能描述：( 线程的各种状态 ) new 新建状态  Runnable 可运行状态  Running 运行状态  Blocked 阻塞状态  Dead 死亡状态
新建线程：NEW
启动线程：RUNNABLE
计时等待：TIMED_WAITING
等待线程：WAITING
唤醒线程：BLOCKED
终止线程：TERMINATED
     * @author: 杨帆
     * @Date:   2018/8/29
*/

public class TestNG4 {

    public static void main(String[] args) throws InterruptedException {

        ThreadState state = new ThreadState();// 创建State对象

        Thread thread = new Thread(state);// 利用State对象创建Thread对象
        System.out.println("新建线程：" + thread.getState());// 输出线程状态

        thread.start(); // 调用thread对象的start()方法，启动新线程
        System.out.println("启动线程：" + thread.getState());

        Thread.sleep(100); // 当前线程休眠0.1秒，使新线程运行waitForASecond()方法
        System.out.println("计时等待：" + thread.getState());

        Thread.sleep(1000); // 当前线程休眠1秒，使新线程运行waitForYears()方法
        System.out.println("等待线程：" + thread.getState());

        state.notifyNow(); // 调用state的notifyNow()方法
        System.out.println("唤醒线程：" + thread.getState());

        Thread.sleep(1000); // 当前线程休眠1秒，使新线程结束
        System.out.println("终止线程：" + thread.getState());
    }
}
