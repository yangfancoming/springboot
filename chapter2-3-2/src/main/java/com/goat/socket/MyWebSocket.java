package com.goat.socket;


import com.goat.date.TimeUtil;
import com.goat.httpUtil.HtmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint("/websocket")
@Component
public class MyWebSocket {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebSocket.class);
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;

    /**
     * 获取在线人数
     *
     * @return 在线人数
     */
    private static synchronized int getOnlineCount() {
        return MyWebSocket.onlineCount;
    }

    /**
     * 添加在线人数
     */
    private static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    /**
     * 减少在线人数
     */
    private static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    /**
     * 有人进入房间
     *
     * @param session session
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        LOGGER.info("有新用户加入!当前在线人数为:{}", getOnlineCount());
    }

    /**
     * 有人离开房间
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一用户关闭!当前在线人数为" + getOnlineCount());
    }

    /**
     * 发消息
     *
     * @param message message
     * @throws IOException IOException
     */
    @OnMessage
    public void onMessage(String message) throws IOException {
        String date = "<font color='green'>" + TimeUtil.getDateNow(TimeUtil.DATE_PATTERN) + "</font></br>";
        // 群发消息
        for (MyWebSocket item : webSocketSet) {
            item.sendMessage(date + message);
        }
        LOGGER.info("客户端消息:{}", HtmlUtil.delHTMLTag(message));
    }

    /**
     * 发送消息
     *
     * @param message message
     * @throws IOException IOException
     */
    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


}
