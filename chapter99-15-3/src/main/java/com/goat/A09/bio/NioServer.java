package com.goat.A09.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: NIO
 * @ author  山羊来了
 * @ date 2019/5/22---19:36
 */
public class NioServer {

    /**
     * NIO 设置 两个阻塞 为 非阻塞 这样就实现了  服务端 单线程情况下  可以连接和接收多个客户端
     缺点： List<SocketChannel> list = new ArrayList<>(); 中 若有2000个连接 其中 1500个 是只连接不发数据 那么 每次还是要遍历2000次   很消耗性能
     解决方法： 选择器 ！
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        List<SocketChannel> list = new ArrayList<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(9876));
        ssc.configureBlocking(false);// 非阻塞

        while (true){
            SocketChannel socketChannel = ssc.accept();
            if (socketChannel == null){
                TimeUnit.SECONDS.sleep(1);
                System.out.println("没人连接");
            }else {
                System.out.println("来人连接了。。。。。。。。。。。。。。。");
                socketChannel.configureBlocking(false);
                list.add(socketChannel);
            }
            test(list,byteBuffer);
        }

    }
    public static void test( List<SocketChannel> list,ByteBuffer byteBuffer) throws IOException {
        for (SocketChannel channel:list){
            int k = channel.read(byteBuffer);
            if (k!=0){
                System.out.println(k+"=============");
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array()));
            }
        }
    }
}
