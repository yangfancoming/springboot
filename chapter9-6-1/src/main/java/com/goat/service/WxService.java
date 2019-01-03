package com.goat.service;

import com.goat.entity.BaseMessage;
import com.goat.entity.TextMessage;
import com.thoughtworks.xstream.XStream;

import java.util.Map;

/**
 * Created by 64274 on 2018/12/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/6---22:38
 */
public class WxService {


    /**
     * 用于处理所有的事件和消息的回复
     * @param requestMap
     * @return 返回的是xml数据包
     * by 罗召勇 Q群193557337
     */
    public static String getRespose(Map<String, String> requestMap) {
        BaseMessage msg=null;
        String msgType = requestMap.get("MsgType");
        switch (msgType) {
            //处理文本消息
            case "text":
                break;
            case "image":
                break;
            case "voice":

                break;
            case "video":

                break;
            case "shortvideo":

                break;
            case "location":

                break;
            case "link":

                break;
            case "event":
                break;
            default:
                break;
        }
        //把消息对象处理为xml数据包
        if(msg!=null) {
            return beanToXml(msg);
        }
        return null;
    }

    /**
     * 把消息对象处理为xml数据包
     * @param msg
     * @return
     * by 罗召勇 Q群193557337
     */
    private static String beanToXml(BaseMessage msg) {
        XStream stream = new XStream();
        //设置需要处理XStreamAlias("xml")注释的类
        stream.processAnnotations(TextMessage.class);
        String xml = stream.toXML(msg);
        return xml;
    }




}
