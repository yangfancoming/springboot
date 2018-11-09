package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Date:   2018/11/9
 *

注意：在我使用2.0.4 版本的spring boot时，始终无法将controller的index方法返回的“index”作为视图名称去解析，而是将其用作url地址跳转，最终抛出异常：
javax.servlet.ServletException: Circular view path [index]:
would dispatch back to the current handler URL [/demo/index] again.
Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
网上查阅了一些资料后，我怀疑是spring boot的版本问题导致该问题的发生。于是将spring boot版本降级至1.4.2，尝试启动项目后，发现一切正常，问题已解决。

*/
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

//    http://localhost:8264/test
    @RequestMapping("/test")
    public String wahaha(ModelMap map) {
        map.addAttribute("host", "你好，我是 Velocity！");
        return "test";
    }

//    http://localhost:8264/index
    @RequestMapping("/index")
    public String index(Model map) {
        map.addAttribute("host", "你好，我是 Velocity！");
        return "index";
    }
}