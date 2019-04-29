package A04_synchronize.example01;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: sos 涉及到多线程 demo 不能使用 junit 进行测试  必须是 psvm
 * @date 2018/7/20---13:29
 加入 sleep 后  售票出现了负数： 随机性和延时性 导致的

卖出相同的票 ： CPU的操作必须是原子性的  eg： i++ 就不是原子性操作，因为他需要两部  1.先取出i的值  2.再将i加1 3.再回写

解决多线程安全问题：
1. 是否是多线程环境
2. 是否有共享数据
3. 是否有多条语句操作（非原子性）共享数据

3 的解决方式： 使用同步代码块 将 非原子性的语句操作共享数据的代码块 包住！
synchronized (object) 实现同步的关键就在于 这个 object 上， 这就好比一把锁，
一定要 多个线程都能共享到这个object 才能实现 多线程的访问锁

同步方法的 锁对象 是： this
静态方法的 锁对象 是： 类的字节码文件  Dog.Class
 */

public class App {

    public static class test1{
        // 会出现  多线程问题
        public static void main(String[] args) {
            MyTask1 myTask1 = new MyTask1();
            new Thread(myTask1,"线程1111").start();// 如果是单线程跑  是没问题的  不会出现线程安全问题
            new Thread(myTask1,"线程2222").start(); // 多个线程跑 就出现线程安全问题
            new Thread(myTask1,"线程3333").start();
        }
    }
    public static class test2{
        //  同步锁  （代码块）
        public static void main(String[] args) {
            MyTask2 myTask2 = new MyTask2();
            new Thread(myTask2,"线程1111").start();
            new Thread(myTask2,"线程2222").start();
            new Thread(myTask2,"线程3333").start();
        }
    }

    public static class test3{
        // 同步锁  （锁方法）
        public static void main(String[] args) {
            MyTask3 myTask3 = new MyTask3();
            new Thread(myTask3,"线程1111").start();
            new Thread(myTask3,"线程2222").start();
            new Thread(myTask3,"线程3333").start();
        }
    }

    public static class test4{
        // 使用 JDK 1.5 之后 Lock 机制 解决多线程问题
        public static void main(String[] args) {
            MyTask4 myTask2 = new MyTask4();
            new Thread(myTask2,"线程1111").start();
            new Thread(myTask2,"线程2222").start();
            new Thread(myTask2,"线程3333").start();
        }
    }
}