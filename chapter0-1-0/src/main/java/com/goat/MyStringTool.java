package com.goat;

import java.nio.charset.StandardCharsets;

/**
 * Created by 64274 on 2018/7/11.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/11---9:54
 */
public class MyStringTool {
    private MyStringTool() { }

    /**
     * @Description: 功能描述：将字符串按照指定长度进行分割
     * @author: Goat
     * @Param: 1234567890    MyStringTool.StrSplit(marks,3);
     * @Return:  123,456,789
     * @Date:   2018/7/11
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
     * @Description: 功能描述：4 字节(8位)字符串     每 n 个字节倒序 （输入 n 长度必须能被 输入字符串的长度整除 否则数据丢失）
     * @author: Goat
     * @Param:   String ret = MyStringTool.StrReverse("1234567890",5);  1234567890 ---- 6789012345
     * @Param:   String ret = MyStringTool.StrReverse("1234567890",2);  1234567890 ---- 9078563412
     * @Return:
     * @Date:   2018/7/11
     */
    public static String strReverse(String str,int mark) {
        StringBuilder heihei = new StringBuilder();
        for (int i = mark; i <= str.length(); i = i + mark){
            heihei.append(str,str.length() - i,str.length() - i +mark);
        }
        return heihei.toString();
    }

    /**
     *
     *
     * @param b byte[] 需要转换的字节数组
     * @return String 十六进制字符串
     */
    /**
     * @Description: 功能描述：字节数组转换为十六进制字符串
     * @author: Goat
     * @Param:  byte[] temp = {0x7e,0x09,0x0A}; MyStringTool.bytes2hex(temp);
     * @Return:  7E090A
     * @Date:   2018/7/12
     */
    public static  String bytes2hex(byte[] b) {
        if (b == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        StringBuilder hs = new StringBuilder();
        String stmp ;
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1) {
                hs.append("0"+stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();
    }
    /**
     * 十六进制串转化为byte数组
     *
     * @return the array of byte
     */
    public static final Integer MARK = 2;

    //    public static final Byte[] hex2bytes(String hex) throws IllegalArgumentException {
    public static  Byte[] hex2bytes(String hex) throws IllegalArgumentException {
        if (hex.length() % MARK != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        Byte[] b = new Byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    /**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: Goat
     * @Param:
     * @Return:
    src：byte源数组
    srcPos：截取源byte数组起始位置（0位置有效）
    dest,：byte目的数组（截取后存放的数组）
    destPos：截取后存放的数组起始位置（0位置有效）
    length：截取的数据长度
     * @Date:   2018/7/12
     */
    //    public static String AscToInt(String temp ){  // 31323334  返回 1234
    //        try {
    //            // 0x31,0x32,0x33,0x34
    //            Byte[] gaga2 = hex2bytes(temp);
    //            for(int i = 0;i<gaga2.length;i++){
    ////                if(gaga2[i]== 0){
    //                    byte[] temp11  = new byte[i];
    //                    System.arraycopy(gaga2, 0, temp11, 0, i);
    //                    // 1234
    //                    String  productNo = new String(temp11,"UTF-8");
    //                    return productNo;
    ////                }
    //            }
    //
    //        }
    //        catch (Exception e){ System.out.println("11111111111");}
    //        return "";
    //    }
    /**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: Goat
     * @Param:    String ret = MyStringTool.IntToAsc("1234");
     * @Return:  31323334
     * @Date:   2018/7/12
     */
    public static String  intToAsc(String haha){
        String temp2 = "";
        try{
            // 0x31,0x32,0x33,0x34
            //            // 代码优化  使用 StandardCharsets.UTF_8 取代 "UTF-8"  避免了魔法值问题
            byte[] gaga = haha.getBytes(StandardCharsets.UTF_8);
            // "31323334"
            temp2 = bytes2hex(gaga);
        }
        catch (Exception e){}
        return temp2;
    }
}
