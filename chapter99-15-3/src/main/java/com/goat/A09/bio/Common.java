package com.goat.A09.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/22---20:18
 */
public class Common {

    public static void test(Socket socket,byte[] bytes) throws IOException {
        System.out.println("等待接收数据。。。。。。。。");
        int read = socket.getInputStream().read(bytes); // 阻塞点 --- 程序释放CPU资源
        System.out.println("接收数据成功。。。。。。。。");
        System.out.println(new String(bytes) +"------"+ read);
    }
}
