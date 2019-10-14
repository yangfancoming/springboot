package com.goat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/10/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/14---12:36
 */
@RestController
@RequestMapping("/mail")
public class TestController {

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String from ; // 读取配置文件中的参数

//    private String to  = "1286031921@qq.com"; // 接收地址
    private String to  = "qianqian.xie@sim.com"; // 接收地址


    //  http://localhost:8621/mail/test1
    @RequestMapping("/test1")
    public void savaUser1() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("简单邮件");
        message.setText("简单邮件的简单内容");
        mailSender.send(message);
    }
}
