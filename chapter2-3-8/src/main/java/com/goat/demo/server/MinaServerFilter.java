package com.goat.demo.server;

import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;


public class MinaServerFilter extends IoFilterAdapter {
    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        System.out.println("服务端过滤器。。。。。。。。。。。。。。。。。messageReceived");
        super.messageReceived(nextFilter, session, message);
    }

    @Override
    public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        System.out.println("服务端过滤器。。。。。。。。。。。。。。。。。messageSent");
        super.messageSent(nextFilter, session, writeRequest);
    }
}
