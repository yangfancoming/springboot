package com.goat.chapter239.handler;



import com.goat.chapter239.chain.Chain;
import com.goat.chapter239.model.Message;
import com.goat.chapter239.strategy.PackageTypeJudge;
import com.goat.chapter239.strategy.PackageTypeService;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;


public class ServerHandler extends IoHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PackageTypeService packageTypeService;

	@Override
	public void messageReceived(IoSession session, Object message) throws IOException {
        ByteArrayInputStream inputStream =  (ByteArrayInputStream)message;
        if (packageTypeService == null){
            logger.info("Spring 注入失败  请联系管理员！");
            return;
        }
        // 策略模式
        Map<Integer, PackageTypeJudge> map = packageTypeService.map;
        PackageTypeJudge packageTypeJudge = map.get(Integer.valueOf(Message.packageType[0]));
        if (packageTypeJudge == null){
            logger.info("未知包类型 请联系管理员！");
            return;
        }

        Chain chain = packageTypeJudge.initChain();
        if (chain == null){
            logger.info("未获取相关处理链 请联系管理员！");
            return;
        }

        // 责任链模式
        ByteArrayInputStream temp = chain.handler(inputStream);
        byte[] result = packageTypeJudge.analysis(temp);
        if (result == null){
            logger.info("数据处理异常 请联系管理员！");
            return;
        }

        // 保存session
        Message.sessions.put(Message.identity,session);
        logger.info("保存session : " + session.getId());
		session.write(result);
	}

	@Override
	public void messageSent(IoSession session, Object message)  {
		logger.info("返回消息内容 : " + message.toString());
	}

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)  {
        logger.error("出现异常 :" + session.getRemoteAddress().toString() + " : " + cause.toString());
        session.write("出现异常");
        session.closeNow();
    }

    @Override
    public void sessionCreated(IoSession session)  {
        InetSocketAddress isa = (InetSocketAddress) session.getRemoteAddress();
        String address = isa.getAddress().getHostAddress();      // IP
        session.setAttribute("address", address);
        logger.info(">>>>>> 来自" + session.getRemoteAddress().toString() + " 的终端上线，sessionId：" + session.getId());
    }

    @Override
    public void sessionOpened(IoSession session)  {
        logger.info("连接打开: " + session.getRemoteAddress().toString());
    }

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)  {
		if (status == IdleStatus.READER_IDLE) {
			logger.info("进入读空闲状态");
			session.closeNow();
		} else if (status == IdleStatus.BOTH_IDLE) {
			logger.info("BOTH空闲");
			session.closeNow();
		}
	}

	@Override
	public void sessionClosed(IoSession session)  {
		logger.info("连接关闭 : " + session.getRemoteAddress().toString());
		int size = session.getService().getManagedSessions().values().size();
        Message.sessions.remove(Message.identity);
        logger.info("连接关闭时session数量==》" + size);
		logger.info("连接关闭时session数量==》" + Message.sessions.size());
	}

}