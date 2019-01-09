package com.goat.socket.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import static com.goat.MinaApplication.logger;


/**
 * socket服务器端处理类
 * @author John Doe
 * @since 2018/04/28 12:14:18
 *
 */
public class ServerHandler extends IoHandlerAdapter {

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)  {
		logger.error("出现异常 :" + session.getRemoteAddress().toString() + " : " + cause.toString());
		session.write("出现异常");
		session.closeNow();
	}

	@Override
	public void sessionCreated(IoSession session)   {
		logger.info("连接创建 : " + session.getRemoteAddress().toString());
	}

	@Override
	public void sessionOpened(IoSession session)   {
		logger.info("连接打开: " + session.getRemoteAddress().toString());
	}

	@Override
	public void messageReceived(IoSession session, Object message)  {
		logger.info("接受到数据 :" + String.valueOf(message));
		String text = String.valueOf(message);
		logger.info("开始分析数据 ");
		String result = analyzeData(text, session);
		session.write(result);

	}

	private String analyzeData(String text, IoSession session)  {
		String responseMessage = "接受到数据";
		return responseMessage;
	}

	@Override
	public void messageSent(IoSession session, Object message)  {
		logger.info("返回消息内容 : " + message.toString());
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
		logger.info("连接关闭时session数量==》" + size);
	}

}