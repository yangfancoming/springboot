package com.goat.A09;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/22---14:54
 */

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

/**
 *1; 通道 channel: 用于源节点与目标节点的链接.在java NIO 中 负责缓冲区中数据的传输.
 * Channel不存储数据.需要配合缓冲区进行传输.
 *
 *2;通道主要实现类:
 *java.nio.channeks.Channel 接口:
 *FileChannel;
 *SokcetChannel;
 *ServerSocketChannel;
 *DatagramChannel;  udp
 *
 *3;获取通道"
 *   1;java 针对支持通道的类提供了 getChannel()方法
 *      FileInputStream /FileoutputStream
 *      randomAccessFile
 *      网络IO:
 *      socket,ServerSocket
 *      DatagramSocket;
 *   2; 在JDK7 中 的 nio.2 针对各个通道提供了静态方法 open()
 *   3; 在JDK7 中 的 nio.2 的Files 工具类中  newByteChannel();
 *
 * 4 通道之间的传输
 * transferFrom()
 * transferTo();
 *
 * 5; 分散(Scatter)与 聚集(Gather)\
 *   分散读取 (Scattering reads) 将通道中的数据分散到缓冲区中
 *   聚集写入(gethering writes)  将缓冲区的数据 聚集到通道
 *
 * 6 字符集
 * 编码   字符串 -> 字符数组  .
 * 解码   字符数组 -> 字符串
 */
public class TestChannel {

    public String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\resources\\";


    @Test
    public void test6() throws CharacterCodingException {
        Charset cs1= Charset.forName("GBK");

        CharsetEncoder ce=cs1.newEncoder(); //获取编码器
        CharsetDecoder cd=cs1.newDecoder(); //获取解码器
        CharBuffer cbuf = CharBuffer.allocate(1024);
        cbuf.put("测试编码器");
        cbuf.flip();

        ByteBuffer bBuf = ce.encode(cbuf); //编码
        for(int i=0;i<10;i++) {
            System.err.println(bBuf.get());
        }
        bBuf.flip();

        CharBuffer cBuf2 = cd.decode(bBuf); //解码
        System.err.println(cBuf2.toString());
    }

    @Test  //字符集
    public void test5() {
        Map<String ,Charset> map = Charset.availableCharsets();
        map.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));
    }

    //分散聚集
    @Test
    public void test4() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile(path + "hello.txt", "rw"); // r rw rws rwd
        FileChannel channel1 = raf1.getChannel();  //获取通道
        //分配多个指定大小缓冲区
        ByteBuffer bf1 = ByteBuffer.allocate(100);
        ByteBuffer bf2 = ByteBuffer.allocate(1024);
        ByteBuffer[] bfs= {bf1,bf2};
        //分散读取
        channel1.read(bfs);
        for (ByteBuffer byteBuffer : bfs) {
            byteBuffer.flip();
        }
        System.err.println(new String(bfs[0].array(), 0,bfs[0].limit()));
        System.err.println("------------------------------");
        System.err.println(new String(bfs[1].array(), 0,bfs[1].limit()));
        channel1.close();

        // 聚集写入
        RandomAccessFile raf2=new RandomAccessFile(path + "hello1.txt", "rw");
        FileChannel channel2=raf2.getChannel();
        channel2.write(bfs);
        channel2.close();
    }


    //3.通道之间的复制  直接缓冲区
    @Test
    public void test3() throws IOException {
        FileChannel inChannel=FileChannel.open(Paths.get(path + "copy01.txt"), StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get(path + "copy02.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        inChannel.transferTo(0,inChannel.size(),outChannel);
        inChannel.close();
        outChannel.close();
    }

    //1.利用通道 和 缓冲区 完成 文件的复制.
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream(path + "copy01.txt");
        FileChannel inChannel=fis.getChannel();
        FileOutputStream fos = new FileOutputStream(path + "copy02.txt");
        FileChannel  outChannel=fos.getChannel();
        //分配指定大小的缓冲区.
        ByteBuffer buf=ByteBuffer.allocate(1024); // 非直接缓冲区
        //将通道中的数据 存入缓冲区.
        while(inChannel.read(buf)!=-1) {
            buf.flip();  //切换读写模式
            outChannel.write(buf); // 通道中的数据 写入缓冲区
            buf.clear();
        }
        inChannel.close();
        outChannel.close();
    }

    //2.使用直接缓冲区完成文件的复制(内存映射文件)  doit 为什么 复制不好使？
    @Test
    public  void  test2() throws IOException {
        FileChannel inChannel =	FileChannel.open(Paths.get(path + "copy01.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(path + "copy02.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inMapBuf =	inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        //直接对缓存区进行数据的读写操作
        byte[] dst=new  byte[inMapBuf.limit()];
        inMapBuf.get(dst);
        outMapBuf.put(dst);
        inChannel.close();
        outChannel.close();
    }

}
