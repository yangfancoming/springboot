package debug.item02;

/**
 * Created by Administrator on 2020/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/27---18:14
 */
public class Box {

    private boolean state = false;

    private int milk;

    public void put(int milk){
        System.out.println("put begin");
        synchronized (this){
            // 刚刚唤醒时 不要进入wait状态
            if (state){
                try {
                    System.out.println("put wait");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("put end");
            }
            this.milk = milk;
            System.out.println("送奶功将第" + this.milk + "瓶牛奶，放入奶箱");
            this.state = true;
            // 唤醒： 自己失去锁，其他线程获得锁
            notifyAll();
        }
    }

    public void get(){
        System.out.println("get begin");
        synchronized (this){
            if (!state){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("用户拿到第" + this.milk+ "瓶牛奶");
            this.state = false;
            notifyAll();
        }
    }
}
