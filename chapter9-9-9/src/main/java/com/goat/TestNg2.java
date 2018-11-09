package com.goat;

import org.testng.annotations.Test;

import java.util.Arrays;

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

}
