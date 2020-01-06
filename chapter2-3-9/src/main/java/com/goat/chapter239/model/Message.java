package com.goat.chapter239.model;

import cn.goatool.core.util.ByteArrayUtils;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*报文*/
public class Message implements Serializable {

    // key dtu身份标识    value session
    public static HashMap<String, IoSession> sessions = new HashMap<>();

    public static byte[] startMark = new byte[]{0x7B};
    public static byte[] packageType = new byte[1];
    public static byte[] packageLength = new byte[2];
    public static byte[] packageIdentity = new byte[11]; // 13900000000
    public static byte[] packageIp = new byte[4];
    public static byte[] packagePort = new byte[2];
    public static byte[] endMark = new byte[]{0x7B};
    public static byte[] user = new byte[]{};

    // dtu ip
    public static String ip;
    // dtu 端口
    public static Short port;
    // dtu 身份标识
    public static String identity;
    // dtu 注册时间
    public static Date time;

    // 已注册成功的 DTU列表 测试
    public static Map<String,Dtu> register = new ConcurrentHashMap<>();



    //  注销成功（DSC 向 DTU 发送此指令时会让 DTU 重新启动）
    public static byte[] haha(){
        Message.packageType = new byte[]{ (byte) 0x82} ;
        Message.packageLength = new byte[]{0x00,0x10};
        Message.packageIdentity = new byte[]{0x31,0x33,0x39,0x30,0x30,0x30,0x30,0x30,0x30,0x30,0x30};
        byte[] bytes = Message.byteMerger(16,new byte[0]);
        return bytes;
    }

    /**
     * @Title： 0x89 发送给 DTU 的用户数据包  服务器主叫命令
     * @author fan.yang
     * @date 2019年11月22日17:16:40
     * @param user 用户数据
     * @param identity 指定DTU 身份标识
     * @return 返回拼装用户数据后的 待发送的完整字节数组
     */
    public static byte[] x89Udp(byte[] user,byte[] identity){
        Message.packageType = new byte[]{ (byte) 0x89} ;
        Message.packageLength = new byte[]{0x00,0x10};
        Message.packageIdentity = identity;
        byte[] bytes = Message.byteMerger(16,user);
        return bytes;
    }

    /**
     * @Title： 0x89 发送给 DTU 的用户数据包  服务器主叫命令
     * @author fan.yang
     * @date 2019年11月22日17:16:40
     * @param user 用户数据
     * @param identity 指定DTU 身份标识
     * @return 返回拼装用户数据后的 待发送的完整字节数组
     */
    public static byte[] x89Tcp(byte[] user,byte[] identity){
        Message.packageType = new byte[]{ (byte) 0x89} ;
        Message.packageIdentity = identity;
        Message.user = user;
        int length = user.length+16;
        Message.packageLength = ByteArrayUtils.shortToByteArr((short)length);
        int l1 = Message.startMark.length;
        int l2 = Message.packageType.length;
        int l3 = Message.packageLength.length;
        int l4 = Message.packageIdentity.length;
        int l5 = Message.user.length;
        int l6 = Message.endMark.length;
        byte[] result = new byte[length];
        System.arraycopy(Message.startMark, 0, result, 0, l1);
        System.arraycopy(Message.packageType, 0, result, l1, l2);
        System.arraycopy(Message.packageLength, 0, result, l1+l2, l3);
        System.arraycopy(Message.packageIdentity, 0, result, l1+l2+l3,l4);
        System.arraycopy(Message.user, 0, result, l1+l2+l3+l4, l5);
        System.arraycopy(Message.endMark, 0, result, l1+l2+l3+l4+l5, l6);
        return result;
    }

    /**
     * @Title： 非用户数据使用
     * @author fan.yang
     * @date 2019年11月22日17:16:40
     * @param length  字节数组长度
     * @return 返回拼装用户数据后的 待发送的完整字节数组
     */
    public static byte[] byteMerger(int length){
       return byteMerger(length,new byte[0]);
    }


    /**
     * @Title： 用户数据使用
     * @author fan.yang
     * @date 2019年11月22日17:16:40
     * @param length  字节数组长度
     * @param user  待拼接的用户数据
     * @return 返回拼装用户数据后的 待发送的完整字节数组
     */
    public static byte[] byteMerger(int length,byte[] user){
        byte[] result = new byte[length + user.length];
        System.arraycopy(Message.startMark, 0, result, 0, 1);
        System.arraycopy(Message.packageType, 0, result, 1, 1);
        System.arraycopy(Message.packageLength, 0, result, 2, Message.packageLength.length);
        System.arraycopy(Message.packageIdentity, 0, result, 2 + Message.packageLength.length, Message.packageIdentity.length);
        System.arraycopy(Message.endMark, 0, result, 2 + Message.packageLength.length + Message.packageIdentity.length, 1);
        System.arraycopy(user, 0, result, 3 + Message.packageLength.length + Message.packageIdentity.length, user.length);
        return result;
    }

    public static void sendToDtu(Dtu dtu , byte[] content, IoConnector connector){
        ConnectFuture cf = connector.connect(new InetSocketAddress(dtu.getIp(),dtu.getPort()));
        cf.awaitUninterruptibly();//等待连接成功
        IoSession session = cf.getSession();
        session.write(content);
    }

}
