package com.goat.controller;

import com.goat.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64274 on 2018/11/14.
 *
 * @author 山羊来了
 * @Description:  该项目 package 打包有问题   由于使用了 0-0-1 项目的model
 * @date 2018年11月14日17:42:16


报错内容：
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.7.0:compile (default-compile) on project chapter2-9-0: Compilation failure: Compilation failure:
[ERROR] /E:/Code/J2EE_code/MySpringBoot/springboot/chapter2-9-0/src/main/java/com/goat/controller/RequestParameterController.java:[3,23] 程序包com.goat.entity不存在
[ERROR] /E:/Code/J2EE_code/MySpringBoot/springboot/chapter2-9-0/src/main/java/com/goat/controller/RequestParameterController.java:[93,48] 找不到符号
[ERROR] 符号:   类 User
[ERROR] 位置: 类 com.goat.controller.RequestParameterController
sos 解决方法：
 1. 把被依赖的 项目 打成jar包
 2. 打成jar包  在 install 一下  其他项目就可以进行引用了
maven的install可以将项目本身编译并打包到本地仓库，这样其他项目引用本项目的jar包时不用去私服上下载jar包，
直接从本地就可以拿到刚刚编译打包好的项目的jar包，很灵活，避免每次都需要重新往私服发布jar包的痛苦；
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
     * http://localhost:8290/request/requestParam  则 不报错，也不会进入该controller 更没有任何提示
     * 	http://localhost:8290/request/requestParam?ownerId=223
     * 	http://localhost:8290/request/requestParam?ownerId111=223  则报错 Required int parameter 'ownerId' is not present
     * @param ownerId
     */
    @GetMapping("/requestParam")
    public Object requestParam(@RequestParam("ownerId") int ownerId) {
        return ownerId;
    }
    /**
     *  指定别名
     * 	http://localhost:8290/request/requestParam11?ownerId111=223  则 不再报错
     * @param ownerId
     */
    @GetMapping("/requestParam11")
    public Object requestParam11(@RequestParam(name = "ownerId111") int ownerId) {
        return ownerId;
    }

    /**
     * 多个请求参数填入到 map  spring会自动封装
     * http://localhost:8290/request/requestParam2?ownerId=223&a=4&c=5
     * @param map
     */
    @GetMapping("/requestParam2")
    public Object requestParam2(@RequestParam Map<String,Object> map) {
        return map;
    }


    /**
     * 多个请求参数填入到 实体类 spring会自动封装
     * http://localhost:8290/request/requestParam2?username=223&password=4&age=5
     * @param user
     */
    @GetMapping("/requestParam22")
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
    @RequestMapping("/requestBodyString")
    public Object requestBodyString(@RequestBody String body){
        return body;
    }


    /**
     * @RequestBody: 请求内容为JSON  javaBean  sos 该注解会自动将 Json串 封装到JavaBean中
     *	  测试方法在：查找 public void requestBodyBean() throws Exception
     * @param user
     */
    @RequestMapping("/requestBodyBean")
    public User requestBodyBean(@RequestBody User user){
        return user;
    }

}
