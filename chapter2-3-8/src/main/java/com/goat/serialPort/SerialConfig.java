package com.goat.serialPort;


import com.goat.socket.SocketFactory;
import com.goat.socket.handler.ServerHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.serial.SerialAddress;
import org.apache.mina.transport.serial.SerialAddress.DataBits;
import org.apache.mina.transport.serial.SerialAddress.FlowControl;
import org.apache.mina.transport.serial.SerialAddress.Parity;
import org.apache.mina.transport.serial.SerialAddress.StopBits;
import org.apache.mina.transport.serial.SerialConnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 64274 on 2019/1/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/9---12:49
 */
@Configuration
public class SerialConfig {

    private static Log log = LogFactory.getLog(SerialConfig.class);

    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }

    @Bean
    public SerialFactory serialProtocolCodecFactory() {
        return new SerialFactory();
    }
    @Bean
    public IoHandlerAdapter ioHandlerAdapter() {
        return new SerialHandler();
    }


    ConnectFuture future ;


    @Bean
    public SerialConnector serialCon()
    {
        //创建串口连接
        SerialConnector connector = new SerialConnector();
        //绑定处理handler
        connector.setHandler(ioHandlerAdapter());
        //设置过滤器
        connector.getFilterChain().addLast("logger",loggingFilter());
        connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(serialProtocolCodecFactory()));

        //配置串口连接
        SerialAddress address = new SerialAddress
                ("COM1", 9600, DataBits.DATABITS_8,StopBits.BITS_1 , Parity.NONE, FlowControl.NONE);

        future = connector.connect(address);
        try {
            future.await();
            //       IoSession sessin = future.getSession();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.info("Serial Server Started");
        return connector;
    }

    public void close()
    {
        future.cancel();
        log.info("UDP Server closed");
    }
}

