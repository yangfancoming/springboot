package com.goat.chapter235;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.netty.tcp.TcpServer;
import reactor.netty.udp.UdpServer;

import java.time.Duration;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // CommandLineRunner是Spring BOOT项目启动时会执行的任务
    @Bean
    CommandLineRunner serverRunner(TcpDecoderHandler tcpDecoderHandler, UdpDecoderHandler udpDecoderHanlder, UdpEncoderHandler udpEncoderHandler, UdpHandler udpHandler) {
        return args ->{
            createUdpServer(udpDecoderHanlder, udpEncoderHandler, udpHandler);
            createTcpServer(tcpDecoderHandler);
            System.out.println(args);
        };
    }

    /**
     * 创建UDP Server
     * @param udpDecoderHandler： 用于解析UDP Client上报数据的handler
     * @param udpEncoderHandler： 用于向UDP Client发送数据进行编码的handler
     * @param udpHandler: 用户维护UDP链接的handler
     */
    private void createUdpServer(UdpDecoderHandler udpDecoderHandler, UdpEncoderHandler udpEncoderHandler, UdpHandler udpHandler) {
        UdpServer.create()
                .handle((in,out) -> {
                    in.receive()
                            .asByteArray()
                            .subscribe();
                    return Flux.never();
                })
//                .host("172.20.10.3") // UDP Server 监听ip
                .host("192.168.1.104") // UDP Server 监听ip
                .port(5002) // UDP Server 监听端口
                .doOnBound(conn -> conn
                        .addHandler("decoder",udpDecoderHandler)
                        .addHandler("encoder", udpEncoderHandler)
                        .addHandler("handler", udpHandler)
                ) //可以添加多个handler
                .bindNow(Duration.ofSeconds(30));
    }

    /**
     * 创建TCP Server
     * @param tcpDecoderHandler： 解析TCP Client上报数据的handler
     */
    private void createTcpServer(TcpDecoderHandler tcpDecoderHandler) {
        TcpServer.create()
                .handle((in,out) -> {
                    in.receive().asByteArray() .subscribe();
                    return Flux.never();
                })
                .doOnConnection(conn ->conn.addHandler(tcpDecoderHandler)) //实例只写了如何添加handler,可添加delimiter，tcp生命周期，decoder，encoder等handler
                .port(9999)
                .bindNow();
    }

}
