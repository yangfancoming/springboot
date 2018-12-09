package com.goat.controller;

import com.goat.util.MessageUtil;
import com.goat.util.TextMessageUtil;
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
//    当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
    //    http://localhost:8961/hello/test1
    @RequestMapping(value = "test",method=RequestMethod.POST)
    public void dopost(HttpServletRequest req,HttpServletResponse rep){
        rep.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        //将微信请求xml转为map格式，获取所需的参数
        Map<String,String> requestMap = MessageUtil.xmlToMap(req);
        String ToUserName = requestMap.get("ToUserName"); // "ToUserName" -> "gh_13a2d9755706"
        String FromUserName = requestMap.get("FromUserName"); // "FromUserName" -> "oKx9z0RrtVwmgeqq2HbtTiL-vr-s"
        String MsgType = requestMap.get("MsgType"); // "MsgType" -> "text"
        String Content = requestMap.get("Content"); // 1
        String CreateTime = requestMap.get("CreateTime"); //  "CreateTime" -> "1544100953"
        String MsgId = requestMap.get("MsgId"); // "MsgId" -> "6631863095283740814"

        String message = null;
        //处理文本类型，实现输入1，回复相应的封装的内容
        if("text".equals(MsgType)){
            TextMessageUtil textMessage = new TextMessageUtil();
            message = textMessage.initMessage(FromUserName,ToUserName,Content);
        }
        try {
            out = rep.getWriter();
            out.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }


    // 接收 GET
    @RequestMapping(value = "test",method=RequestMethod.GET)
    public String test(HttpServletRequest req,HttpServletResponse rep){
        String signature = req.getParameter("signature");  // 45e02aa4d9152289b5fd2f2106d1deece8ac5c2e
        String nonce = req.getParameter("nonce");   // 5918109
        String timestamp = req.getParameter("timestamp");  // 1542023745
        String echostr = req.getParameter("echostr");   // 5422247344881659631
        String encrypt_type = req.getParameter("encrypt_type");  // null
        String msg_signature = req.getParameter("msg_signature"); // null

        System.out.println(signature + "\n" + nonce + "\n" + timestamp + "\n" + echostr + "\n" + encrypt_type + "\n" + msg_signature);
        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        if (wxMpService.checkSignature(timestamp, nonce,signature)) {
            return echostr;
        }
        return "非法请求";
    }

}
