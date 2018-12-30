package com.goat.controller;

import com.goat.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64274 on 2018/11/14.
 *
 * @author 山羊来了
 * @Description:  doit  该项目打包有问题   由于使用了 0-0-1 项目的model
 * @date 2018年11月14日17:42:16
 */

@RestController
@RequestMapping(value = "/request")
public class RequestParameterController {


    // =================== @PathVariable =============================
    /**
     * 单个 @PathVariable值
     * http://localhost:8290/request/path/1
     * @param ownerId
     */
    @RequestMapping(value="/path/{ownerId}")
    public String  pathVariable(@PathVariable String ownerId){
        return ownerId;
    }

    /**
     * 单个 @PathVariable值  正则校检 只能接受一个 纯数字的参数
     * http://localhost:8290/request/path/1
     * @param ownerId
     */
    @RequestMapping(value="/path/{ownerId:\\d+}")
    public String  pathVariable1(@PathVariable String ownerId){
        return ownerId;
    }
    /**
     * 多个@PathVariable值
     * http://localhost:8290/request/path/1/pet/1234
     * @param ownerId
     * @param petId
     */
    @RequestMapping(value="/path/{ownerId}/pet/{petId}")
    public Object pathVariable2(@PathVariable String ownerId, @PathVariable String petId){
        Map<String,Object> map = new HashMap<>(16);
        map.put("ownerId", ownerId);
        map.put("petId", petId);
        return map;
    }

    // =================== @RequestParam =============================

    /**
     * 可以从请求参数中获取参数值
     * 	http://localhost:8290/request/requestParam?ownerId=223
     * 	http://localhost:8290/request/requestParam?ownerId111=223  则报错 Required int parameter 'ownerId' is not present
     * @param ownerId
     */
    @RequestMapping(value="/requestParam", method = RequestMethod.GET)
    public Object requestParam(@RequestParam("ownerId") int ownerId) {
        return ownerId;
    }
    /**
     *  指定别名
     * 	http://localhost:8290/request/requestParam11?ownerId111=223  则 不再报错
     * @param ownerId
     */
    @RequestMapping(value="/requestParam11", method = RequestMethod.GET)
    public Object requestParam11(@RequestParam(name = "ownerId111") int ownerId) {
        return ownerId;
    }

    /**
     * 多个请求参数填入到 map  spring会自动封装
     * http://localhost:8290/request/requestParam2?ownerId=223&a=4&c=5
     * @param map
     */
    @RequestMapping(value="/requestParam2", method = RequestMethod.GET)
    public Object requestParam2(@RequestParam Map<String,Object> map) {
        return map;
    }
    /**
     * 多个请求参数填入到 实体类 spring会自动封装
     * http://localhost:8290/request/requestParam2?username=223&password=4&age=5
     * @param user
     */
    @RequestMapping(value="/requestParam22", method = RequestMethod.GET)
    public Object requestParam22(@RequestParam User user) {
        return user;
    }

    /**
     * 设置@RequestParam自定义参数：如设置默认值，是否必须等等
     * http://127.0.0.1:8290/request/requestParam3
     * 或
     * http://127.0.0.1:8290/request/requestParam3?inputStr=myInput
     * @param inputStr
     */
    @RequestMapping("/requestParam3")
    public Object requestParam3(@RequestParam(value="inputStr", required=true, defaultValue="noInput") String inputStr ) {
        return inputStr;
    }

    // =================== @RequestBody =============================
    /**
     * @RequestBody: 请求内容为JSON  字符串
     *	  测试方法在：查找 public void requestBodyString() throws Exception
     * @param body
     */
    @RequestMapping(value = "/requestBodyString", method = RequestMethod.POST)
    public Object requestBodyString(@RequestBody String body){
        return body;
    }


    /**
     * @RequestBody: 请求内容为JSON  javaBean  sos 该注解会自动将 Json串 封装到JavaBean中
     *	  测试方法在：查找 public void requestBodyBean() throws Exception
     * @param user
     */
    @RequestMapping(value = "/requestBodyBean", method = RequestMethod.POST)
    public User requestBodyBean(@RequestBody User user){
        return user;
    }

}
