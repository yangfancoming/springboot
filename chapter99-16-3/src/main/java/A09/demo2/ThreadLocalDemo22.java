package A09.demo2;

/**

 * 没有先set，直接get的话，运行时会报空指针异常，
 * 重写了initialValue方法可以解决这个问题
 */
public class ThreadLocalDemo22 {

    private ThreadLocal<Long> longThreadLocal = ThreadLocal.withInitial(()->Thread.currentThread().getId());

    private ThreadLocal<String> stringThreadLocal = ThreadLocal.withInitial(()->Thread.currentThread().getName());

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
        final ThreadLocalDemo22 demo2 = new ThreadLocalDemo22();

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