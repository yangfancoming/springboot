package com.goat.socket;

import java.io.*;
import java.net.*;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: 客户端
 * @ author  山羊来了
 * @ date 2019/4/23---22:00
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(3000);
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),2000));
        System.out.println("客户端信息："+socket.getLocalAddress().toString()+"\t"+socket.getLocalPort());
        System.out.println("服务端信息："+socket.getInetAddress().toString()+"\t"+socket.getPort());

        try {
            send(socket);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
            System.out.println("出现异常111");
        }
    }

    public static void send(Socket client) throws IOException {

        // 获取键盘输入
        InputStream in = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        do{
            String s1 = bufferedReader.readLine();
            System.out.println(s1);

            // 发送数据 到服务器
            PrintStream printStream = new PrintStream(client.getOutputStream());
            printStream.println(s1);

            // 获取 服务器回显数据
            BufferedReader server = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String s = server.readLine();
            System.out.println(s);
        }while (true);

        //        printStream.close();
    }
}
