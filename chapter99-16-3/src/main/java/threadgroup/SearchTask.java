package threadgroup;

import model.Result;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/22---13:50
 */

public class SearchTask implements Runnable {

    public SearchTask(Result result) {
        this.result = result;
    }

    private Result result;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread Start " + name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
        System.out.println("Thread end " + name);
    }

    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(),  value);
        TimeUnit.SECONDS.sleep(value);
    }



}

