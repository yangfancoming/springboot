# 粘包问题

    客户端循环发送消息给服务器端：
                for (int i = 0; i < 10; ++i) {
                    ByteBuf buffer = Unpooled.copiedBuffer("sent from client ", Charset.forName("utf-8"));
                    ctx.writeAndFlush(buffer);
                }
                

    服务器端接收消息：
    
    服务端接收到的消息内容： sent from client sent from client sent from client sent from client sent from client sent from client sent from client sent from client sent from client sent from client 
    服务端接收到的消息数量： 1
    
     客户端接收到 服务器端返回的消息：
        客户端接收到的消息内容： abb0eae3-b40f-45f1-bd3d-dc6b537d3e84
        客户端接收到的消息数量： 1
     

    