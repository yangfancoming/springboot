package threadgroup;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: 通过 UncaughtExceptionHandler 来捕获子线程异常
 * @ author  山羊来了
 * @ date 2019/4/22---13:57
 */
public class ThreadExcep extends ThreadGroup {
    private ThreadExcep() {
        super("线程组的名字");
    }

    @Override
    public void uncaughtException(Thread thread, Throwable e) {
        System.out.println("捕获子线程异常！");
        System.out.println(thread.getId());
        e.printStackTrace();
    }
    public static void main(String[] args) {
        ThreadExcep excep = new ThreadExcep();
        Thread thread = new Thread(excep, () -> {
            throw new NullPointerException("空指针异常");
        });
        thread.start();
    }
}