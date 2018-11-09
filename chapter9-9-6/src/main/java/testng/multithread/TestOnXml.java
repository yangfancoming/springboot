package testng.multithread;

import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---16:02
 */
public class TestOnXml {
    @Test
    public void test1(){
        System.out.println("TestOnXml......test1.........."+ Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println("TestOnXml......test2.........."+ Thread.currentThread().getId());
    }


    @Test
    public void test3(){
        System.out.println("TestOnXml......test3.........."+ Thread.currentThread().getId());
    }
}
