package com.goat.chapter239;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2019/12/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/26---16:49
 */
public class App {

    @Test
    public void test(){
        String str = "helloWorld";
        ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());
        //读取两个字节
        buff.get();
        buff.get();
        System.out.println("position:"+ buff.position()+"\t limit:"+buff.limit());
        buff.mark();
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());
        buff.flip();
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());
    }
}
