package com.goat.controller;

import com.goat.bean.RequestMessage;
import com.goat.bean.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by 64274 on 2018/8/24.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/24---3:08
 */
@Controller
public class WebSocketController {

    @Resource
    private SimpMessagingTemplate messagingTemplate ;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    // 当浏览器向服务器发送请求时，通过 @MessageMapping 注解来映射 /welcome 地址
    @MessageMapping("/welcome")
    public ResponseMessage toTopic(RequestMessage msg) {
        System.out.println("======================"+msg.getMessage());
        this.messagingTemplate.convertAndSend("/api/v1/socket/send",msg.getMessage());
        return new ResponseMessage("欢迎使用webScoket："+msg.getMessage());
    }

    @MessageMapping("/message")
    @SendTo // 当服务器 有消息时，会对订阅了  @SendTo 中的路径的客户端发送消息
    public ResponseMessage toUser(RequestMessage msg ) {
        System.out.println(msg.getMessage());
        this.messagingTemplate.convertAndSendToUser("123","/message",msg.getMessage());
        return new ResponseMessage("欢迎使用webScoket："+msg.getMessage());
    }
}