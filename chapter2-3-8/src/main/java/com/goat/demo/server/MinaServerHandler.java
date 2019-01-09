package com.goat.demo.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.net.InetSocketAddress;
import java.util.Date;


/**
 * @author ZERO:
 * @version 2017-3-27 下午3:59:33
 * 业务逻辑实现
 */
public class MinaServerHandler extends IoHandlerAdapter {

	@Override
	public void sessionCreated(IoSession iosession) { 
		InetSocketAddress sa=(InetSocketAddress)iosession.getRemoteAddress();
		String address=sa.getAddress().getHostAddress(); //访问的ip
		System.out.println("服务端与客户端创建连接..."+"访问的IP:"+address);
	}

	@Override
	public void sessionOpened(IoSession iosession) { 
		System.out.println("服务端与客户端连接打开...");
	}
    
	@Override
	public void messageReceived(IoSession session,Object message) {
        String msg = message.toString();
		 System.out.println("服务端收到的数据为:"+msg);
		 if("exit".equals(msg)){  //服务端断开的条件
			 session.closeNow();
		 }
		 Date date=new Date();
		 session.write(date); //返回给服务端数据
	}

	 @Override
	    public void messageSent(IoSession session, Object message)  {
	        System.out.println("服务端发送信息成功...");
	    }

	    @Override
	    public void sessionClosed(IoSession session)  {
            System.out.println("服务端进入关闭状态...");
	    }

	    @Override
	    public void sessionIdle(IoSession session, IdleStatus status){
	        System.out.println("服务端进入空闲状态...");
	    }

	    @Override
	    public void exceptionCaught(IoSession session, Throwable cause){
            System.out.println("服务端发送异常" + cause);
	    }
	
	
}
