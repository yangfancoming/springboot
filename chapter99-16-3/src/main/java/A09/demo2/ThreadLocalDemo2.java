package A09.demo2;

/**
 *
 * result:
 * 1
 * main
 * 11
 * Thread-0
 * 1
 * main
 *
 * 从这段代码的输出结果可以看出，在main线程中和thread1线程中，
 * longLocal保存的副本值和stringLocal保存的副本值都不一样。
 * 最后一次在main线程再次打印副本值是为了证明在main线程中和thread1线程中的副本值确实是不同的。
 */
public class ThreadLocalDemo2 {

    private ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    private ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    private void set(){
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    private long getLong(){
        return longThreadLocal.get();
    }

    private String getString(){
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException{
        final ThreadLocalDemo2 demo2 = new ThreadLocalDemo2();

        demo2.set();

        System.out.println(demo2.getLong());
        System.out.println(demo2.getString());

        Thread thread1 = new Thread(){
            public void run(){
                demo2.set();
                System.out.println(demo2.getLong());
                System.out.println(demo2.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(demo2.getLong());
        System.out.println(demo2.getString());
    }

}