package com.goat.test;


import com.goat.CrcTool;
import com.goat.MyStringTool;
import org.testng.annotations.Test;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class CrcTest {

    @Test
    public void test() {

    }

    @Test
    public void test1(){
        String data  = "1234";
        Byte[] data1= MyStringTool.hex2bytes(data);
        String crc16 = CrcTool.getCrc16(data1, data1.length);//获取crc检验码
        System.out.println(crc16);
    }

}
