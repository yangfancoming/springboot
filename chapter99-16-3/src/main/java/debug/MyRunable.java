package debug;

/**
 * Created by Administrator on 2020/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/27---18:02
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "进入");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "离开");
    }
}
