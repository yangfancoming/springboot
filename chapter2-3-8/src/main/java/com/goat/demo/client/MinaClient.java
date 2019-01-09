package com.goat.demo.client;

import org.apache.log4j.Logger;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.HashMap;


/**
 * @author ZERO
 * @version 2017-3-27 下午5:59:54
 * mina 客户端
 */
public class MinaClient {
    private static String HOST = "127.0.0.1";
    private static int PORT = 3333;
    private static  IoConnector connector = new NioSocketConnector();
    private static  IoSession session;

	/* 
    * 测试服务端与客户端程序！
    a. 启动服务端，然后再启动客户端
    b. 服务端接收消息并处理成功;
    */
	public static void main(String[] args) {
        connector.setConnectTimeoutMillis(3000); // 设置链接超时时间
        connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"),LineDelimiter.WINDOWS.getValue(),LineDelimiter.WINDOWS.getValue())));// 添加过滤器  可序列话的对象
        connector.setHandler(new MinaClientHandler());  // 添加业务逻辑处理器类
        ConnectFuture future = connector.connect(new InetSocketAddress( HOST, PORT));// 创建连接
        future.awaitUninterruptibly();// 等待连接创建完成
        session = future.getSession();// 获得session  会话连接
        session.write("hello! goat");
        session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
        connector.dispose();
//    	bindstart();
//    	pushstart();
    }
    
    public static void bindstart(){
        System.out.println("客户端绑定服务端");
        // 创建一个非阻塞的客户端程序
        HashMap<String,String> sy= new HashMap<>();
        sy.put("channel", "xiaoai");
        sy.put("deviceId", "12-ab");
        sy.put("device", "1456");
        sy.put("appVersion", "Version 1.5.1");
        sy.put("account", "0030000100009702");
        sy.put("client_bind","client_bind");
        System.out.println("SentBody:"+sy);
        // session.setAttribute("account","hello world");
        session.write(sy);// 发送消息
        System.out.println("终端与服务端建立连接成功...发送的消息为:"+sy);
        session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
        connector.dispose();
    }
    
    public static void pushstart(){
    	System.out.println("客户端请求服务端推送");
   	 // 创建一个非阻塞的客户端程序 
    //   IoConnector connector = new NioSocketConnector();
       // 设置链接超时时间
       try {
            HashMap<String,String> sy= new HashMap<>();
           sy.put("closeTV", "closeTV");
           sy.put("account", "0030000100009702"); //账号
           sy.put("put","client_online");
           System.out.println("SentBody:"+sy.toString());
        //   session.setAttribute("account","hello world");
           session.write(sy);// 发送消息
           System.out.println("客户端与服务端建立连接成功...发送的消息为:"+sy);
       } catch (Exception e) {
       	   e.printStackTrace();
           System.out.println("客户端链接异常...");
       }
//       session.getCloseFuture().awaitUninterruptibly();// 等待连接断开
//       connector.dispose();
   }
    
}
