package com.goat.chapter254.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.junit.Test;

/**
 * Created by Administrator on 2019/12/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/25---17:17
 */
public class App {

    // 测试地址： http://localhost:8899/   返回 Hello World
    @Test
    public void test(){

        // boss 事件循环组 获取客户端的连接   负责将处理客户端连接事件转发给 worker
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 工人 事件循环组  专门负责boss分配的活
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup,workerGroup)
                    // 通过反射方式创建
                    .channel(NioServerSocketChannel.class)
                    // 自定义 子处理器
                    .childHandler(new TestInit());

            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
