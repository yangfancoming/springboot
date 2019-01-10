package com.goat.client;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;


public class MinaClientFilter extends IoFilterAdapter {
    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        System.out.println("客户端过滤器。。。。。。。。。。。。。。。。。messageReceived");
        super.messageReceived(nextFilter, session, message);
    }

    @Override
    public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        System.out.println("客户端过滤器。。。。。。。。。。。。。。。。。messageSent");
        super.messageSent(nextFilter, session, writeRequest);
    }
}
