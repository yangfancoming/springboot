package com.goat.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: 服务器端
 * @ author  山羊来了
 * @ date 2019/4/23---22:00
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2000); // 监听端口
        System.out.println("服务端信息："+server.getInetAddress().toString()+server.getLocalPort());

        //等待客户端连接
        while (true){
            Socket client = server.accept();
            new Thread(new ClientHandler(client),"123").start();
        }

    }

    private static class ClientHandler implements Runnable{

        private Socket socket;
        private boolean flag = true;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("新客户端信息："+socket.getLocalAddress().toString()+socket.getPort());
            // 得到打印流 用于数据输出 和 服务器会送数据使用
            try {
                PrintStream printStream = new PrintStream(socket.getOutputStream());

                // 得到输入流 用于接收数据
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do{
                    String s = bufferedReader.readLine();
                    System.out.println(s);
                    if ("bye".equals(s)){
                        flag = false;
                    }
                    printStream.println("回送数据："+s);
                }while (flag);

                printStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {socket.close(); } catch (IOException e) { e.printStackTrace(); }
                System.out.println("出现异常222");
            }


        }
    }
}
