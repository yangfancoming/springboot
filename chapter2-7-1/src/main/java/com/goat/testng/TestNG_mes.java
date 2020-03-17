package com.goat.testng;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goat.pojo.HttpClientResult;
import com.goat.utils.HttpClientUtils;
import org.junit.Test;
//import org.springframework.test.context.ContextConfiguration;

import java.util.HashMap;
import java.util.Map;

//@ContextConfiguration(classes= HttpClientApplication.class)
public class TestNG_mes {

    /**
         * @Description:  测试  mes 系统  HTTPClient 请求
         * @author: Goat
         * @Date:   2018/10/15
    */
    @Test
    public void test1() throws Exception { // 请求 所有 pn 数据
        HttpClientResult result = HttpClientUtils.doGet("http://192.168.166.89/ws/findAllPn");
        System.out.println(result);
    }

    @Test
    public void test2() throws Exception { // 请求  upn 为 X00021123364 的数据
        HttpClientResult result = HttpClientUtils.doGet("http://192.168.166.89/ws/findByUpn/X00021123364");
        System.out.println(result);
    }


    @Test
    public void test3() throws Exception {  // 请求 自己 电脑  url
        HttpClientResult result2 = HttpClientUtils.doPost("http://192.168.1.115:8081/wms/warehouseSplit/updateWarehouseSplit");
        System.out.println(result2);
    }

    @Test
    public void test4() throws Exception { // HttpClient doPost请求 发送 map 对象
        Map<String,String> map = new HashMap<>();
        map.put("haha","111");
        map.put("gaga","222");
        HttpClientResult result2 = HttpClientUtils.doPost("http://192.168.1.115:8081/wms/warehouseSplit/updateWarehouseSplit",map);
        System.out.println(result2);
    }

    @Test
    public void test5() throws Exception { // HttpClient doPost请求 发送 JSONObject 对象
        String s = "{\"name\":\"peter\"},{\"name1\":\"peter2\"}";
        JSONObject object = JSON.parseObject(s);
        JSONObject result2 = HttpClientUtils.doPost("http://192.168.1.115:8081/wms/warehouseSplit/updateWarehouseSplit",object);
        System.out.println(result2);
    }

    /**
         * @Description:
         * @author: Goat
         * @Param:
         * @Return:
         * @Date:   2018/10/16
    */
    @Test
    public void test6() throws Exception { // HttpClient doPost请求 发送 json 字符串  实际代表数组 因为 字符串中有 []

        String  temp = "[{\"upn\":X0001100014601743,\"stockCount\":\"6000\"},{\"upn\":X00011000146017437,\"stockCount\":\"500\"},{\"upn\":X00011000146017438, \"stockCount\":\"500\"}]";
        // 下面代码 string 会报错 ：Expected BEGIN_ARRAY but was BEGIN_OBJECT at line 1 column 2 (期望的是数组 接收到的却是对象)  因为 没有用 [] 中括号
        //  String  temp = "{\"upn\":X0001100014601743,\"stockCount\":\"6000\"},{\"upn\":X00011000146017437,\"stockCount\":\"500\"},{\"upn\":X00011000146017438, \"stockCount\":\"500\"}";
        String result2 = HttpClientUtils.doPost("http://192.168.1.115:8081/wms/warehouseSplit/updateWarehouseSplit",temp);
        System.out.println(result2);
    }

}
