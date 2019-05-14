package com.goat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TestNg5 {



    public static void main(String[] args) {
        System.out.println(removeRepeatChar("aabbcc"));

    }

    //字符串去重
    public static String removeRepeatChar(String str){
        if(str == null) return str;
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for(int i = 0;i<len;i++){
            if(i == str.indexOf(str.charAt(i))){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){

        String a = "aabbcc";
        String s = testJ8(a);
        System.out.println(s);
    }

    public String testJ8(String str){
        char[] chars = str.toCharArray();
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            temp.add(chars[i]+"");
        }
        return temp.stream().distinct().collect(Collectors.toList()).toString();
    }


}
