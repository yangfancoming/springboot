package A04_synchronize.example01;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---13:25
 */
public class MyTask4 extends Thread {
    private   int tickets = 50;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            if(tickets<=0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + tickets--);
            lock.unlock();
        }
    }

}
