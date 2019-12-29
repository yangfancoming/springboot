package cn.goatool.core.util;

import java.nio.charset.StandardCharsets;

/**
 * 字符串工具类
 * @date 2018/7/11---9:54
 */
public class StringUtil {

    /**
     * @Description: 将字符串按照指定长度进行分割
     * @param str 待转换的字符串
     * 输入示例：   MyStringTool.StrSplit("1234567890",3);
     * 输出结果：   123,456,789
     * @author goat
     * @date 2018/7/11
     */
    public static String[] StrSplit(String str, int len){
        int length = str.length() / len;
        String[] shcuy = new String[length];
        for (int i = 0; i < length; i++){
            shcuy[i] = str.substring(0,len);
            str = str.substring(len);
        }
        return shcuy;
    }

    /**
     * @Description: 4 字节(8位)字符串     每n个字节倒序 （输入n长度必须能被 输入字符串的长度整除 否则数据丢失）
     * @param str 待转换的字符串
     * 输入示例：   String ret = MyStringTool.StrReverse("1234567890",5);
     * 输出结果：   6789012345
     * 输入示例：   String ret = MyStringTool.StrReverse("1234567890",2);
     * 输出结果：   9078563412
     * @author goat
     * @date 2018/7/11
     */
    public static String strReverse(String str,int mark) {
        StringBuilder heihei = new StringBuilder();
        for (int i = mark; i <= str.length(); i = i + mark){
            heihei.append(str,str.length() - i,str.length() - i +mark);
        }
        return heihei.toString();
    }

    /**
     * @Description: 将十进制的字符串 转换成ascii
     * @param str 待转换的字符串
     * 输入示例：   String ret = MyStringTool.IntToAsc("1234");
     * 输出结果：   31323334
     * @author goat
     * @date 2018/7/12
     */
    public static String intToAsc(String str){
        // 0x31,0x32,0x33,0x34
        byte[] gaga = str.getBytes(StandardCharsets.UTF_8);
        return ByteArrayUtil.byteArrToHexString(gaga);
    }



}
