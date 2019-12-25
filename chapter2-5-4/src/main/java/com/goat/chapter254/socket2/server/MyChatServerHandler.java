package com.goat.chapter254.socket2.server;


import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler extends SimpleChannelInboundHandler<String>{

    // 保存所有已经与服务端建立好连接的客户端对象
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        // 将当前客户端发送来的消息  广播给其他的客户端
        channelGroup.forEach(ch -> {
            if(channel != ch) {
                ch.writeAndFlush(channel.remoteAddress() + " 发送的消息：" + msg + "\n");
            } else {
                ch.writeAndFlush("【自己】" + msg + "\n");
            }
        });
    }

    // 有新的客户端连接
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        // 获取当前客户端连接对象
        Channel channel = ctx.channel();
        // 广播/通知 所有已连接客户端  xxx客户端上线
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 加入\n");
        // 将已连接的客户端对象添加到组中
        channelGroup.add(channel);
    }

    // 有客户端断开连接  （该方法 再客户端/手机  强制关机/开启飞行模式的情况下 是不会被调用的，需要心跳包检测！）
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 获取当前对开的客户端对象
        Channel channel = ctx.channel();
        // 广播/通知 所有已连接客户端  xxx客户端下线
        channelGroup.writeAndFlush("【服务器】- " + channel.remoteAddress() + " 离开\n");
        channelGroup.remove(channel);
        System.out.println(channelGroup.size());
        // 将已连接的客户端对象从组中移除 （此行代码不写也行 netty会自动调用  可以通过观看channelGroup.size()来证明）
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
