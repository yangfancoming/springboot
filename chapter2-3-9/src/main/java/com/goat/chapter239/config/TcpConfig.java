package com.goat.chapter239.config;


import com.goat.chapter239.chain.Chain;
import com.goat.chapter239.chain.PackageUserTcp;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Administrator on 2019/11/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/25---17:23
 *
 * spring:
 *   socket:
 *     type:
 *       enabled: true # false   true
 */
@Configuration
@ConditionalOnProperty(name = "spring.socket.type.enabled", havingValue = "TCP")
public class TcpConfig extends MinaConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public IoAcceptor ioAcceptor() throws Exception {
        IoAcceptor acceptor = new NioSocketAcceptor(); // TCP
        super.commonServer(acceptor);
        logger.info("Socket服务器在端口：" + "已经启动 TCP");
        return acceptor;
    }

    @Bean
    public Chain socketUser() {
        Chain socketUser = new PackageUserTcp(); // TCP
        logger.info("已经启动 TCP 方式解析用户数据");
        return socketUser;
    }

    @Bean
    public IoConnector datagramConnector() {
        NioSocketConnector connector = new NioSocketConnector(); // TCP
        super.commonClient(connector);
        logger.info("TCP 客户端配置成功！");
        return connector;
    }
}
