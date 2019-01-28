package com.goat;

import com.goat.date.TimeUtil;
import org.junit.Before;
import org.junit.Test;



//@RunWith(SpringRunner.class)
//@SpringBootTest
public class Mytest {


    @Before
    public void test() {

    }

    @Test
    public void test1() {
        long timeInMillis = TimeUtil.getTimeInMillis(2019, 1, 28, 10, 20, 32, 0);
        System.out.println(timeInMillis);
    }
    @Test
    public void test2() {
        String timeInMillis = TimeUtil.getCurrentMonth();
        System.out.println(timeInMillis);
    }
    @Test
    public void test3() {
        String timeInMillis = TimeUtil.getCurrMonth();
        System.out.println(timeInMillis);
    }
}
