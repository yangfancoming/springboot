package com.goat.demo.client;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;


/**
 * @author ZERO
 * @version 2017-3-27 ??6:01:31
 * 客户端handle
 */
public class MinaClientHandler extends IoHandlerAdapter {
    private static Logger logger = Logger.getLogger(MinaClientHandler.class);

    @Override
    public void messageReceived(IoSession session, Object message) {
        String msg = message.toString();
        System.out.println("客户端接收的数据:" + msg);
      //  if(msg.equals(XiaoaiConstant.CMD_HEARTBEAT_REQUEST)){
        System.out.println("成功收到心跳包");
    //    	session.write(XiaoaiConstant.CMD_HEARTBEAT_RESPONSE);
   //     }
       
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        System.out.println("发生错误:" + cause);
    }
}
