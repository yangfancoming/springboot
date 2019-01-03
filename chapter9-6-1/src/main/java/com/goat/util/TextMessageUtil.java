package com.goat.util;

import com.goat.entity.TextMessage;
import com.thoughtworks.xstream.XStream;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextMessageUtil implements BaseMessageUtil<TextMessage> {

	public String messageToxml(TextMessage message) {
		XStream xstream  = new XStream();
		xstream.alias("xml", message.getClass());
		return xstream.toXML(message);
	}



    @Override
    public String initMessage(String fromUserName, String toUserName,String content) {

        TextMessage text = new TextMessage();
		text.setToUserName(fromUserName);
		text.setFromUserName(toUserName);
		text.setCreateTime(new Date().getTime());
		text.setMsgType("text");

		String result ;
        try {
            result = scheduling("20181209",content);
        } catch (ParseException e) {
            text.setContent("请您输入正确的时间格式！");
            return  messageToxml(text);
        }
        text.setContent("您的排班是：" + result);
	    return  messageToxml(text);
	}

    public static String scheduling(String start,String end) throws ParseException {
        String[] haha = {"正休","白班","夜班","下夜"};
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date1 = dateFormat.parse(start);
        Date date2 = dateFormat.parse(end);
        Long result =Math.abs((date1.getTime()-date2.getTime())/(24*3600*1000)) ;
        // 两日期 相差  后与4取余 因为 一共就四种排班
        Integer temp = Math.toIntExact((result % 4));
        // 与4 取余结果 只有 0 1 2 3 四种结果 对应 数组中的四种排班  顺序暂时写死
        return haha[temp];
    }
}
