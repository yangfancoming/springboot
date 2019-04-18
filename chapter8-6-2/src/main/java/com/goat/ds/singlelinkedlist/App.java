package com.goat.ds.singlelinkedlist;

import org.junit.Test;

/**
 * Created by 64274 on 2019/4/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/18---8:48
 */
public class App {

    SingleLinkedList sl = new SingleLinkedList();

    @Test
    public void test(){
        boolean empty = sl.isEmpty();
        System.out.println(empty);
    }

    @Test
    public void test1(){
        sl.addHead(11);
        sl.addHead("11");
        System.out.println(sl.isEmpty());
    }

    @Test
    public void test2(){
        sl.addHead(11);
        sl.addHead("22");
        sl.addHead(true);
        sl.display();
    }

    @Test
    public void test3(){
        sl.addHead(11);
        sl.display();
    }
}
