package com.goat.config;

import com.goat.handler.NettyWebSocketChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 64274 on 2019/2/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/5---23:53
 */

@Configuration
@PropertySource(value= "classpath:/nettyserver.properties")
public class NettyConfig {

    @Value("${tcp.port}")
    private int tcpPort;
    @Value("${boss.thread.count}")
    private int bossCount;
    @Value("${worker.thread.count}")
    private int workerCount;
    @Value("${so.keepalive}")
    private boolean keepAlive;
    @Value("${so.backlog}")
    private int backlog;


    /** boss 线程 负责监听 客户端的连接请求*/
    @Bean(name = "bossGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup() {
        return new NioEventLoopGroup(bossCount);
    }

    /** 工作 线程 负责处理 boss线程 分配的任务 */
    @Bean(name = "workerGroup", destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workerGroup() {
        return new NioEventLoopGroup(workerCount);
    }

    @Autowired
    @Qualifier("somethingChannelInitializer")
    private NettyWebSocketChannelInitializer nettyWebSocketChannelInitializer;

    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap() {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(), workerGroup())
                .channel(NioServerSocketChannel.class) // 指定通道我 NIO 方式
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(nettyWebSocketChannelInitializer)// 自定义的子处理器
        .option(ChannelOption.SO_BACKLOG,128)
        .childOption(ChannelOption.SO_KEEPALIVE,true)// 保持这个链接
        ;

//        ChannelFuture sync = b.bind(8899).sync();
        //        Map<ChannelOption<?>, Object> tcpChannelOptions = tcpChannelOptions();
//        Set<ChannelOption<?>> keySet = tcpChannelOptions.keySet();
//        for (@SuppressWarnings("rawtypes") ChannelOption option : keySet) {
//            b.option(option, tcpChannelOptions.get(option));
//        }
        return b;
    }
    @Bean(name = "tcpSocketAddress")
    public InetSocketAddress tcpPort() {
        return new InetSocketAddress(tcpPort);
    }


    @Bean(name = "tcpChannelOptions")
    public Map<ChannelOption<?>, Object> tcpChannelOptions() {
        Map<ChannelOption<?>, Object> options = new HashMap<>();
        options.put(ChannelOption.SO_KEEPALIVE, keepAlive);
        options.put(ChannelOption.SO_BACKLOG, backlog);
        return options;
    }
}
