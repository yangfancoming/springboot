package com.goat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 64274 on 2018/6/12.
 */
@Controller
public class HelloWorld {
    @GetMapping("/hello")
    public void helloworld(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello Spring-boot 2018年10月13日14:01:46");
    }
}
