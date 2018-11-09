package com.goat;


import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class MyStringTest {

    @Test
    public void test() {

    }

    MyArrayTool myArrayTool = MyArrayTool.getInstance();
    @Test
    public void test3(){
        String marks = "1234567890";
        String[] hoho1 = MyStringTool.StrSplit(marks,3);
        String lolo = myArrayTool.StrPrint(hoho1);
        System.out.println(lolo);
    }

    @Test
    public void StrReverse(){
        String marks = "1234567890";
        String ret = MyStringTool.StrReverse(marks,2);
        System.out.println(ret);
    }
    @Test
    public void bytes2hex(){
        byte[] temp = {0x7e,0x09,0x0A};
        String ret = MyStringTool.bytes2hex(temp);
        System.out.println(ret);
    }
    @Test
    public void hex2bytes(){
        String temp = "1234";
        Byte[] ret = MyStringTool.hex2bytes(temp);
        String haha = MyArrayTool.getInstance().StrPrint(ret);
        System.out.println(haha);
    }

    @Test
    public void IntToAsc(){
        String temp = "1234";
        String ret = MyStringTool.IntToAsc(temp);
        System.out.println(ret);
    }
    @Test
    public void StrSplit(){
//        String temp = "1234";
//        String[] ret = MyStringUtilsKt.Companion.strSplit(temp,2);
//        System.out.println(ret);
    }
    @Test
    public void leftPad(){
        String test ="123";
        String value = StringUtils.leftPad(test,10, "0");
        System.out.println(value);
    }

}
