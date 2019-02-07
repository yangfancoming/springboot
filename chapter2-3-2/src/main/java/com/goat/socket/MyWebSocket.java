package com.goat.socket;


import com.goat.date.TimeUtil;
import com.goat.httpUtil.HtmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint("/websocket")
@Component
public class MyWebSocket {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebSocket.class);
    private static int onlineCount = 0;

    /*** concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    /*** 与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;

    /**
     * 获取在线人数
     * @return 在线人数
     */
    private static synchronized int getOnlineCount() {
        return MyWebSocket.onlineCount;
    }

    /*** 添加在线人数 */
    private static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    /*** 减少在线人数 */
    private static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    /*** 连接建立成功调用的方法 (有人进入房间) */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        LOGGER.info("有新用户加入!当前在线人数为:{}", getOnlineCount());
    }

    /*** 连接关闭调用的方法 (有人离开房间) */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一用户关闭!当前在线人数为" + getOnlineCount());
    }
    /*** 发生错误时调用  */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    /*** 收到客户端消息后调用的方法 (客户端发送过来的消息) */
    @OnMessage
    public void onMessage(String message) throws IOException {
        String date = "<font color='green'>" + TimeUtil.getDateNow(TimeUtil.DATE_PATTERN) + "</font></br>";
        for (MyWebSocket item : webSocketSet) {  // 群发消息
            item.sendMessage(date + message);
        }
        LOGGER.info("客户端消息:{}", HtmlUtil.delHTMLTag(message));
    }


    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


}
