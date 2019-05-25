package com.goat.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.goat.service.IBarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bar")
public class BarController {

    /**
     *  服务提供者项目 启动后 dubbo-admin 会发现 有两个 IBarService 服务 版本分别是 1.0.0 和 2.0.0
     *   @Reference(version = "1.0.0")   测试 http://localhost:8537/bar/name 返回 version1
     *   @Reference(version = "2.0.0")   测试 http://localhost:8537/bar/name 返回 version2
     *   注意 更改版本配置后 必须重启项目 否则无效
     */
    @Reference(version = "2.0.0")
    public IBarService barService;

    // http://localhost:8537/bar/name
    @RequestMapping("/name")
    public void hello() {
        String s = barService.testMutiVersion();
        System.out.println(s);
    }


}
