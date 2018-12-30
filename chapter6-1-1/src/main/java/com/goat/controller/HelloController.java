package com.goat.controller;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Api(value = "/", tags = "swagger2 Demo  java接口")
@Api("用户信息管理")
@RestController
@RequestMapping("/hello")
public class HelloController {


//    http://localhost:8611/hello/hellola

    @ApiOperation(value="java 遇见用户", notes="java 根据用户打招呼")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID1", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user1", value = "用户详细实体user1", required = true, dataType = "User") })

    @RequestMapping(value ="/test1",method = RequestMethod.GET)
    public void test1(){
        System.out.println("11111");
    }



    @ApiOperation("获取地址信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "province", dataType = "String", required = true, value = "省", defaultValue = "广东省"),
            @ApiImplicitParam(paramType = "query", name = "area", dataType = "String", required = true, value = "地区", defaultValue = "南山区"),
            @ApiImplicitParam(paramType = "query", name = "street", dataType = "String", required = true, value = "街道", defaultValue = "桃园路"),
            @ApiImplicitParam(paramType = "query", name = "num", dataType = "String", required = true, value = "门牌号", defaultValue = "666")})
    @ApiResponses({@ApiResponse(code = 400, message = "请求参数没填好"),@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")})

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public void test2(){
        System.out.println("2222");
    }

    @ApiOperation(value = "获取XXXX信息", notes = "我是描述")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", name = "address", dataType = "Address", required = true, value = "省", defaultValue = "广东省"),
    })

    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    public void test3(){
        System.out.println("3333");
    }
}
