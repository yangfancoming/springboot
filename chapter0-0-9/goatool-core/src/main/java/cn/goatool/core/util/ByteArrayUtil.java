
package cn.goatool.core.util;


public class ByteArrayUtil {


    /**
     * @Description: 功能描述：数组反转  反转后数组的第一个元素等于源数组的最后一个元素：
     * 输入示例：  byte[] byteArrs = {2, 1, 14, 22, 18, 3, 27, 20};
     * 输出结果：  { 20,27,3,18,22,14,1,2 }
     * @author: Goat
     * @Date:   2018/7/12
     */
    public static byte[] reverseArray(byte[] Array) {
        byte[] new_array = new byte[Array.length];
        for (int i = 0; i < Array.length; i++) {
            new_array[i] = Array[Array.length - i - 1];
        }
        return new_array;
    }

    /**
     * 字节数组转short
     * @param bytes 待转换的字节数组
     * 输入示例：  byte[] bytes = new byte[]{0x00,0x09};
     * 输出结果：  9
     * @author: Goat
     * @Date:   2018/7/12
     */
    public static short byteArrToShort(byte[] bytes) {
        int FF = 0xff;
        int first = (bytes[0] & FF) << 8;
        return (short) (first | (bytes[1] & FF));
    }

    /**
     * 注释：short到字节数组的转换！
     * @param x 00 19
     * @return
     */
    public static byte[] shortToByteArr(short x) {
        byte high = (byte) (0x00FF & (x >> 8));//定义第一个byte
        byte low = (byte) (0x00FF & x);//定义第二个byte
        byte[] bytes = new byte[2];
        bytes[0] = high;
        bytes[1] = low;
        return bytes;
    }

    /**
     * 将包装类型的字节数组转换成基本类型
     * @param objectsArray 待转换的基本类型字节数组
     * 输入示例：   Byte[] byte = {0x38,0x03,0x00,0x00,0x00,0x05};
     * 输出结果：   byte[] byte = {0x38,0x03,0x00,0x00,0x00,0x05};
     * @author goat
     * @date 2019年12月4日17:14:07
     */
    public static byte[] convertToPrimitiveArray(Byte[] objectsArray) {
        final byte[] bytes = new byte[objectsArray.length];
        for (int i = 0; i < objectsArray.length; i++) {
            bytes[i] = objectsArray[i];
        }
        return bytes;
    }

    /**
     * 将基本类型字节数组转换成包装类型
     * @param primitiveArray 待转换的基本类型字节数组
     * 输入示例：   byte[] byte = {0x38,0x03,0x00,0x00,0x00,0x05};
     * 输出结果：   Byte[] byte = {0x38,0x03,0x00,0x00,0x00,0x05};
     * @author goat
     * @date 2019年12月4日17:14:07
     */
    public static Byte[] convertToObjectArray(byte[] primitiveArray) {
        final Byte[] objects = new Byte[primitiveArray.length];
        for (int i = 0; i < primitiveArray.length; i++) {
            objects[i] = primitiveArray[i];
        }
        return objects;
    }


    public static String byteArrToHexString(byte[] byteArr) {
        return byteArrToHexString(byteArr,byteArr.length,true);
    }

    public static String byteArrToHexString(byte[] byteArr,boolean mark) {
        return byteArrToHexString(byteArr,byteArr.length,mark);
    }

    /**
     * 将字节数组 转成十六进制字符串输出
     * @param byteArr 待转换的字节数组
     * @param length  要转换的长度
     * @param mark    转换大小写标记 true 大写   false 小写
     * 输入示例：   byte[] test1 = {0x38,0x03,0x00,0x00,0x00,0x05};
     * 输出结果：   [38,03,00,00,00,05]
     * 输入示例：   byte[] temp = {0x7e,0x09,0x0A};
     * 输出结果：   [7E,09,0A]
     * @author goat
     * @date 2019/11/20 14:38
     */
    public static String byteArrToHexString(byte[] byteArr, int length,boolean mark) {
        if (byteArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        StringBuffer returnValue = new StringBuffer();
        for (int i = 0; i < length; i++) {
            String hex = Integer.toHexString(byteArr[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            if (i != length - 1) {
                hex += ",";
            }
            String result = (mark==true) ? hex.toUpperCase(): hex.toLowerCase();
            returnValue.append(result);
        }
        return "[" + returnValue.toString() + "]";
    }

    /**
     * @Description: 十六进制字符串 转化为byte数组
     * @param hex 待转换的 十六进制字符串
     * 输入示例：   String ret = MyStringTool.hex2bytes("7B01");
     * 输出结果：   [0x7B,0x01]
     * @author goat
     * @date 2018/7/12
     */
    public static byte[] hex2bytes(String hex) throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

}
