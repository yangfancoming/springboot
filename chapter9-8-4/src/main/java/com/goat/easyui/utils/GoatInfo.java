package com.goat.easyui.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by 64274 on 2018/4/30.
 */
public class GoatInfo {

    public static Map getInfo(HttpServletRequest request) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer(); //  {"_name":"123","_class":"123","_sid":"123","_sex":"1","_age":123}
        String temp;
        while ((temp = br.readLine()) != null) {sb.append(temp);}
        br.close();
        Map maps = (Map) JSON.parse(sb.toString()); // 这里 只能解析 json 不能解析其他数据类型！
        return  maps;
    }

}
