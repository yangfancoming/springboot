
package cn.goatool.core.util;


public class ByteArrayUtil {

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

}
