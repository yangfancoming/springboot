package com.goat.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/14.
 *
 * @ Description: @PathVariable 注解学习
 * @ author  山羊来了
 * @ date 2020/1/14---13:04
 */
@RestController
@RequestMapping(value = "/pathVariable")
public class PathVariableController {

    /**
     * 单个 @PathVariable值
     * http://localhost:8290/pathVariable/path1/1
     * @param ownerId
     */
    @RequestMapping(value="/path1/{ownerId}")
    public String  pathVariable(@PathVariable String ownerId){
        return ownerId;
    }

    /**
     * 单个 @PathVariable值  正则校检 只能接受一个 纯数字的参数
     * http://localhost:8290/pathVariable/path2/1
     * @param ownerId
     */
    @RequestMapping(value="/path2/{ownerId:\\d+}")
    public String  pathVariable1(@PathVariable String ownerId){
        return ownerId;
    }

    /**
     * 多个@PathVariable值
     * http://localhost:8290/pathVariable/path3/1/pet/1234
     * @param ownerId
     * @param petId
     */
    @RequestMapping(value="/path3/{ownerId}/pet/{petId}")
    public Object pathVariable2(@PathVariable String ownerId, @PathVariable String petId){
        Map<String,Object> map = new HashMap<>(16);
        map.put("ownerId", ownerId);
        map.put("petId", petId);
        return map;
    }
}
