package A01_create.example00;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 创建线程的方式三： 实现Callable接口
 * @ author  山羊来了
 * @ date 2019/4/29---15:15
 */
public class ThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            sum += i;
        }
        return sum;
    }
}
