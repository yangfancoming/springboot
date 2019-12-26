package com.goat.chapter239.config;

import com.goat.chapter239.chain.Chain;
import com.goat.chapter239.chain.PackageUserUdp;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Created by Administrator on 2019/11/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/25---17:23
 */
@Configuration
@ConditionalOnProperty(name = "spring.socket.type.enabled", havingValue = "UDP")
public class UdpConfig  extends MinaConfig{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public IoAcceptor ioAcceptor() throws IOException {
        IoAcceptor acceptor = new NioDatagramAcceptor();// UPD
        super.commonServer(acceptor);
        logger.info("Socket服务器在端口：" + "已经启动 UDP");
        return acceptor;
    }

    @Bean
    public Chain socketUser() {
        Chain socketUser = new PackageUserUdp(); // UPD
        logger.info("已经启动 UPD 方式解析用户数据");
        return socketUser;
    }

    @Bean
    public IoConnector datagramConnector() {
        NioDatagramConnector connector = new NioDatagramConnector();// UDP
        super.commonClient(connector);
        logger.info("UDP 客户端配置成功！");
        return connector;
    }
}
