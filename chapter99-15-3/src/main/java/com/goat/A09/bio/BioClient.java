package com.goat.A09.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/22---19:50
 */
public class BioClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",9876));
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入内容：");
            String next = scanner.next();
            socket.getOutputStream().write(next.getBytes());
        }
    }
}
