package com.goat.fastjson.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goat.fastjson.utils.JsonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


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

    List<List<Object>> object = new ArrayList<>();     // excle 数据 准备

    //   http://localhost:8222/demo/test4?josnFileName=ningxia.json
    //   http://localhost:8222/demo/test4?josnFileName=liaoning.json
    @GetMapping("/test4")
    public void test4(String josnFileName) throws Exception  {
        object.clear();
        JSONObject log = JsonUtils.readJsonFromClassPath(josnFileName, JSONObject.class);
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
            Object url = jsonObject.get("url");
            System.out.println("解析url属性：" + url);
            List<Object> record = new ArrayList<>();
            record.add(time);
            record.add(url);
            object.add(record);
        }
        doSaveExcel("D:\\temp\\宁夏.xls"); // "D:\\辽宁.xls" "D:\\宁夏.xls"
    }

    public void doSaveExcel(String excelPath) throws IOException {
        OutputStream out = new FileOutputStream(excelPath);
        ExcelWriter writer = EasyExcelFactory.getWriter(out, ExcelTypeEnum.XLS,true);
        Sheet sheet1 = new Sheet(1, 3);
        writer.write1(object, sheet1);
        writer.finish();
        out.close();
    }
}
