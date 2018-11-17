package com.goat.controller;

import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by 64274 on 2018/11/12.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/12---19:21
 *
signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
timestamp	时间戳
nonce	随机数
echostr	随机字符串
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    protected WxMpService wxMpService;

    //    http://localhost:8961/hello/test1
    @RequestMapping(value = "test1",method=RequestMethod.GET)
    public String hello(HttpServletRequest req){
        String signature = req.getParameter("signature"); // 45e02aa4d9152289b5fd2f2106d1deece8ac5c2e
        String nonce = req.getParameter("nonce"); // 5918109
        String timestamp = req.getParameter("timestamp"); // 1542023745
        String echostr = req.getParameter("echostr"); // 5422247344881659631
//        String encrypt_type = req.getParameter("encrypt_type"); // null
//        String msg_signature = req.getParameter("msg_signature"); // null

        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) throw new IllegalArgumentException("请求参数非法，请核实!");

        if (wxMpService.checkSignature(timestamp, nonce,signature)) {
            return echostr;
        }
        return "非法请求";
    }

    @RequestMapping(value = "test1",method=RequestMethod.POST)
    public void dopost(HttpServletRequest request,HttpServletResponse response){
        System.out.println("111111111111111111");
    }

}
