package com.goat.util;

import com.goat.bean.TextMessage;
import com.thoughtworks.xstream.XStream;


import java.util.Date;

public class TextMessageUtil implements BaseMessageUtil<TextMessage> {

	public String messageToxml(TextMessage message) {
		XStream xstream  = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}

	@Override
	public String initMessage(String FromUserName, String ToUserName) {
		TextMessage text = new TextMessage();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("欢迎关注机械振动工程党支部");
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
	    return  messageToxml(text);
	}

	public String initMessage(String FromUserName, String ToUserName,String Content) {
		TextMessage text = new TextMessage();
		text.setToUserName(FromUserName);
		text.setFromUserName(ToUserName);
		text.setContent("您的排班是：2018年12月6日20:53:34"+Content);
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");
	    return  messageToxml(text);
	}


}
