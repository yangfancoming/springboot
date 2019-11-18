package com.goat.chapter235;

import org.junit.Test;

/**
 * Created by Administrator on 2019/11/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/15---15:29
 */
public class App {

    @Test
    public void test() throws Exception{
        byte [] array = new byte[10000];//创建一个数组

        ByteArrayOutStream out = new ByteArrayOutStream(array);
//        out.writeByte(10);
//        out.writeShort(23);
//        out.writeInt(1111);
//        out.writeLong(3333333);
//        out.writeBoolean(true);
//        out.writeChar('a');
//        out.writeFloat(0.123f);
//        out.writeDouble(10.123d);
        out.writeUTF("hello world!");


        ByteArrayInStream in = new ByteArrayInStream(array);
//        System.out.println(in.readByte());
//        System.out.println(in.readShort());
//        System.out.println(in.readInt());
//        System.out.println(in.readLong());
//        System.out.println(in.readBoolean());
//        System.out.println(in.readChar());
//        System.out.println(in.readFloat());
//        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

    }
}
