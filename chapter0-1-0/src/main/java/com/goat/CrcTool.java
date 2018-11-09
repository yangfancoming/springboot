package com.goat;


/**
     * @Description: 功能描述：CRC校检工具类
     * @author: 杨帆
     * @Param: 
     * @Return: 
     * @Date:   2018/7/12
*/
public class CrcTool {
    private CrcTool() { }
    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: 杨帆
         * @Param:  Byte[] data1= MyStringTool.hex2bytes("1234");  String crc16 = CRCUtil.getCrc16(data1, data1.length);
         * @Return:  C613
         * @Date:   2018/7/12
    */
    public static String getCrc16(Byte[] data_arr, int data_len) {
        int crc16 = 0;
        int i;
        for (i = 0; i < (data_len); i++) {
            crc16 = (char) ((crc16 >> 8) | (crc16 << 8));
            crc16 ^= data_arr[i] & 0xFF;
            crc16 ^= (char) ((crc16 & 0xFF) >> 4);
            crc16 ^= (char) ((crc16 << 8) << 4);
            crc16 ^= (char) (((crc16 & 0xFF) << 4) << 1);
        }
        int[] result = new int[2];
        result[0] = (crc16 / 256);
        result[1] = (crc16 % 256);
        String s = (String.format("0x%02X", result[1])).substring(2) +
                (String.format("0x%02X", result[0])).substring(2);
        return s;
    }
}
