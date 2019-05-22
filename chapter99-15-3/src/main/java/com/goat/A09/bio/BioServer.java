package com.goat.A09.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/22---19:36
 */
public class BioServer {

    /** 传统 BIO 缺点
     *  由于 accept() 和  read() 两个阻塞点 导致  服务端在 单线程状态下 无法处理并发
     *  解决方法 使用多线程 将阻塞点 迁移到子线程中
    */

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket();
        s.bind(new InetSocketAddress(9876));

        while (true){
            System.out.println("等待连接。。。。。。。。");
            Socket socket = s.accept();// 阻塞点 --- 程序释放CPU资源
            System.out.println("连接成功。。。。。。。。");
            Common.test(socket,new byte[1024]);
        }
    }
}
