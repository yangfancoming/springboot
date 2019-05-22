package com.goat.A09;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/22---14:50
 */

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * 缓冲区 buffer  在javaNIO 中 负责数据的存取.缓冲区就是数组.用于存储不同数据类型的数据
 * 根据数据类型不同,提供了相应类型的缓冲区:
 * ByteBuffer,CharBuffer,shortBuffer,IntBuffer,LongBUffer,FloatBuffer,DoubleBuffer
 * 管理方式几乎一致.通过 allocate()获取缓冲区
 *缓冲区 存取数据方法" put()  get()

 *缓存区四个核心属性:
 *capacity  容量, 表示缓冲区中最大存储数据的容量.一旦声明不能改变.
 *limit:    限制. 表示缓冲区中可以操作数据的大小.(limit 后数据不能进行读写)
 *position: 位置. 表示缓冲区中正在操作数据的位置.
 *position<=limit<=capacity
 *mark : 标记: 表示记录当前position 的位置.可以通过reset()恢复到mark的位置.
 *
 *直接缓冲区 和 非直接缓冲区:
 * 非直接缓存区:通过 allocate() 方法 分配缓冲区 将缓冲区建立在jvm 的内存中
 * 直接缓冲区  :通过 allocateDirect() 方法分配直接缓存区,将缓冲区建立在物理内存中 可以提高效率.
 *
 */
public class TestBuffer {

    @Test
    public void test3() {
        ByteBuffer buf= ByteBuffer.allocateDirect(1024);
        System.err.println(buf.isDirect());
        test(buf);
    }

    @Test
    public void test2() {
        String str="abcdefghjkl";
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();
        byte[] b=new byte[buf.limit()];
        buf.get(b, 6, 4);
        buf.get(b, 7, 3);
        System.out.println(new String(b, 6, 4));
        System.out.println(new String(b, 7, 3));
        System.out.println(buf.position());

        //标记
        buf.mark();

        buf.get(b, 0, 1);
        System.out.println(new String(b, 0, 1));
        System.out.println(buf.position());
        //恢复到标记mark 位置
        buf.reset();
        System.out.println(buf.position());

        System.out.println(buf.hasRemaining());// 判断缓冲区中是否还有剩余的数据
    }

    @Test
    public void  test1() {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("----1.分配存取一个指定大小的缓存区----------allocate()");
        test(buf);
        System.out.println("----2.利用put 方法存入数据----------------put()");
        buf.put("abcde".getBytes());
        test(buf);

        buf.flip();
        System.out.println("----3.切换成读取的模式;filp()----------------buf.flip()");
        test(buf);

        System.out.println("----4.get  读取缓冲区----------------buf.get()");
        byte[] dst=new  byte[buf.limit()];
        buf.get(dst,0,2);
        test(buf);
        System.out.println(new String(dst, 0, dst.length));

        buf.rewind();
        System.out.println("-----5. rewind() 可重复读数据---------------buf.rewind()");
        byte[] dsts=new  byte[buf.limit()];
        buf.get(dsts);
        System.out.println(new String(dsts, 0, dst.length));
        test(buf);

        buf.clear();
        System.out.println("-----6.清空缓冲区. clear() 缓冲区的数据依然存在.单处于被遗忘状态.---------------buf.clear()");
        test(buf);
        //缓冲区的数据依然存在.单处于被遗忘状态.
        System.out.println((char)buf.get(2));
    }
    public void test(ByteBuffer buf){
        System.out.println("position："+buf.position());
        System.out.println("limit："+buf.limit());
        System.out.println("capacity："+buf.capacity());
    }

    @Test
    public  void mains() throws IOException {
        File file = new File("H:\\test\\1\\test.txt");
        if(file.exists()){
            InputStream input = new FileInputStream(file);
            byte[] data = new byte[1024];//假设要读的长度为1024
            int len = input.read(data);//该方法返回的是数据个数
            input.close();
            System.out.println(new String(data,0,len));//文件里没有那么多字节，转为字符串输出。
            //现实中字节流的应用：手机短信最多70个字
        }
    }
}
