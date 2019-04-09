package com.goat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     * @Description: 功能描述：
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class TestNg2 {

    @Test
    public void test(){
        String ids = "1,2,3,4";
        Arrays.stream(ids.split(",")).forEach(o ->System.out.println(Long.valueOf(o)));
    }


    @Test
    public void test1(){

        Person person = new Person();
        List<Person> list = new ArrayList<>(16);
        for (int i = 0; i < 5; i++) {
            person.setAge(i);
            list.add(person); // 这里添加的都是同一个对象 导致 list 里 都是同样的对象
        }
        System.out.println(list);
    }

    @Test
    public void test3(){
        boolean temp = verifications("11,22", "11");
        System.out.println(temp);
    }

    public static boolean verifications(String rules,String code) {
        if(StringUtils.isBlank(rules)||StringUtils.isBlank(code)){
            return false;
        }
        boolean res = false; // 将 boolean 改成 Boolean 提示就消失了呢？
        String[] rule = rules.split(",");
        for(String r:rule){
            res = verification(r,code);
            if(res) return true;
        }
        return res; // doit  为什么这里  会提示  Value 'res' is always 'false'
    }

    private static boolean verification(String rule, String code) {
        byte[] rb = rule.toUpperCase().getBytes();
        byte[] cb = code.toUpperCase().getBytes();
        for(int i = 0;i<rb.length;i++){
            if(rb[i]=='?') continue;
            if(cb.length <= i || rb[i] != cb[i]) {
                return false;
            }
        }
        return true;
    }


}
