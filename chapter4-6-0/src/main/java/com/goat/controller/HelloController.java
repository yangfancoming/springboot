package com.goat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/mes/APP")
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 测试地址： http://localhost:8080/test/test1?pn=JYAC0E0053H0
    @RequestMapping("/location/getLocationByPn")
    public String hellola(String pn){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select AREA_NAME from WS_AREA_INFO where PN = ?", pn);
        if (list == null || list.size()<=0){
            return "没有查询对应库位！";
        }
        Object area_name = list.get(0).get("AREA_NAME");
        return area_name.toString();
    }


}
