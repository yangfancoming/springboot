package com.goat.A09.bio;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by 64274 on 2019/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/22---20:13
 */
public class MyTask implements Runnable {

    Socket socket;

    byte[] bytes = new byte[1024];

    public MyTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Common.test(socket,bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
