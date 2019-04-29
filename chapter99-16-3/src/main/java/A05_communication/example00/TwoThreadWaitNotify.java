package A05_communication.example00;

/**
 * Created by 64274 on 2019/4/29.
 *  等待通知模式是 Java 中比较经典的线程通信方式。
 *  两个线程通过对同一对象调用等待 wait() 和通知 notify() 方法来进行通讯。
 *  这里的线程 A 和线程 B 都对同一个对象 TwoThreadWaitNotify.class 获取锁，A 线程调用了同步对象的 wait() 方法释放了锁并进入 WAITING 状态。
 * B 线程调用了 notify() 方法，这样 A 线程收到通知之后就可以从 wait() 方法中返回。

 有一些需要注意:
     wait() 、nofify() 、nofityAll() 调用的前提都是获得了对象的锁(也可称为对象监视器)。
     调用 wait() 方法后线程会释放锁，进入 WAITING 状态，该线程也会被移动到等待队列中。
     调用 notify() 方法会将等待队列中的线程移动到同步队列中，线程状态也会更新为 BLOCKED
     从 wait() 方法返回的前提是调用 notify() 方法的线程释放锁，wait() 方法的线程获得锁。

 * @ Description: 两个线程交替打印奇偶数
 * @ author  山羊来了
 * @ date 2019/4/29---13:19
 */
public class TwoThreadWaitNotify {

    public int start = 1;
    public boolean flag = false;

    public static void main(String[] args) {
        TwoThreadWaitNotify twoThread = new TwoThreadWaitNotify();

        Thread t1 = new Thread(new OuNum(twoThread));
        t1.setName("A");

        Thread t2 = new Thread(new JiNum(twoThread));
        t2.setName("B");

        t1.start();
        t2.start();
    }

}
