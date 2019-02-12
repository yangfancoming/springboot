package com.goat.job;

/**
 * Created by 64274 on 2019/2/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/12---16:11
 */
public  class MyJob2 implements Runnable {

    private Integer mark ;

    public MyJob2() {
    }

    public MyJob2(int mark) {
        this.mark = mark;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--------------"+ mark);
        }
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
