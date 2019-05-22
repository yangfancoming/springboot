package com.goat.A09.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: 服务器端 采用多线程模式
 * @ author  山羊来了
 * @ date 2019/5/22---19:36
 */
public class BioServerMuti {

    /**
     将 read() 使用多线程处理后  一个服务端 可以接收多个客户端的连接
     这样就将 read() 的阻塞点 迁移到了子线程中阻塞  而不会阻塞主线程
     服务端多线程的缺点： 如果有大量线程 只连接 不发送数据 那么服务端 将维护这些大量没有意义的线程  代价是很高昂的
     解决方法：使用 单线程 解决并发 NIO  即 不让 accep() 和 read() 两个方法 阻塞 ！
    */
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket();
        s.bind(new InetSocketAddress(9876));

        while (true){
            System.out.println("等待连接。。。。。。。。");
            Socket socket = s.accept();// 阻塞点 --- 程序释放CPU资源
            System.out.println("连接成功。。。。。。。。");
            MyTask myTask = new MyTask(socket);
            new Thread(myTask).start();
        }
    }
}
