package com.goat.fastjson.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goat.fastjson.utils.JsonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * 宁夏 json数据转换成excel表格
 * 需要提取字段
 * url： 请求api
 * 请求参数：queryString
 * 执行时间：time属性
 * json文件样例详见 类路径下的 ningxia.json
*/

@RestController
@RequestMapping("/demo")
public class DemoController {

    //   http://localhost:8222/demo/test4
    @GetMapping("/test4")
    public void test4() throws Exception  {

        JSONObject log = JsonUtils.readJsonFromClassPath("ningxia.json", JSONObject.class);
        System.out.println(log);
        // 获取log 根节点
        JSONObject log1 = (JSONObject) log.get("log");
        // 获取根节点下的 entries 集合节点
        JSONArray entries = (JSONArray) log1.get("entries");
        System.out.println(entries.size());
        // 遍历entries 集合节点下的每个子节点
        for (int i = 0; i < entries.size(); i++) {
            Object time = ((JSONObject) entries.get(i)).get("time");
            System.out.println("解析time属性：" + time);
            // 解析request节点
            JSONObject jsonObject = (JSONObject)((JSONObject) entries.get(i)).get("request");
            // 获取request节点下的 url属性
            System.out.println("解析url属性：" + jsonObject.get("url"));
            JSONArray queryStringArr = (JSONArray) jsonObject.get("queryString");
            if ( queryStringArr.size()<= 0) continue;
            // 解析请求参数
            String name = (String) ((JSONObject) queryStringArr.get(i)).get("name");
            System.out.println("解析name属性：" + name);
            String value = (String) ((JSONObject) queryStringArr.get(i)).get("value");
            System.out.println("解析value属性：" + value);
        }
    }


}
