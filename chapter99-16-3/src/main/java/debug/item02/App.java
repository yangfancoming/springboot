package debug.item02;

/**
 * Created by Administrator on 2020/1/27.
 *
 * @ Description: 通过多线程调试  查看  notifyAll();wait(); 的执行流程
 * @ author  山羊来了
 * @ date 2020/1/27---18:27
 */
public class App {

    public static void main(String[] args) {
         Box box = new Box();
         Producer producer = new Producer(box);
         Consumer consumer = new Consumer(box);

         Thread thread1 = new Thread(producer,"生产者");
         Thread thread2 = new Thread(consumer,"消费者");

         thread1.start();
         thread2.start();
    }
}
