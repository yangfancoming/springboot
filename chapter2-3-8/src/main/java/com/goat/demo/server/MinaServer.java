package com.goat.demo.server;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;


/**
 * @author ZERO:
 * @version 2017-3-27 下午3:20:11
 * 创建服务端
 */
public class MinaServer {

	/* 启动此类 提示服务端运行成功后
	 * Windows 命令 输入  telnet 127.0.0.1 3333
	 * 然后输入消息  hello
	 * 消息为bye的时候关闭连接
	 * */
	public static void main(String[] args) throws IOException {
        IoAcceptor ia = new NioSocketAcceptor(); //创建一个非堵塞的server端Socket
//        InetSocketAddress pt = new InetSocketAddress(3333); //设置端口
        // 设置过滤器（使用Mina提供的文本换行符编解码器）
//        ia.getFilterChain().addLast("codec",  new ProtocolCodecFilter(new ObjectSerializationCodecFactory())); //创建 协议编码解码过滤器ProtocolCodecFilter
        String temp = LineDelimiter.WINDOWS.getValue();
        ia.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"),temp,temp)));
        ia.getFilterChain().addLast("filter",new MinaServerFilter()); // 注册服务端过滤器
        ia.getSessionConfig().setReadBufferSize(2048); //设置读取数据的缓存区大小
        ia.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10); //读写通道10秒内无操作进入空闲状态
        ia.setHandler(new MinaServerHandler()); //绑定逻辑处理器
        ia.bind(new InetSocketAddress(3333)); //绑定端口
        System.out.println("服务端启动成功...端口号为:"+3333);
	}
	
}
