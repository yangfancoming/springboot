package com.goat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
/**
     * @Description:
     * @author: 杨帆
     * @Date:   2018/10/29
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private JavaMailSender mailSender; //自动注入的Bean

    @Value("${spring.mail.username}")
    private String from; // 读取配置文件中的参数

    private String to = "1286031921@qq.com"; // 接收地址

    @Autowired
    private TemplateEngine templateEngine;

    // 使用thymeleaf模板发送邮件
    @Test
    public void sendTemplateMail() throws  Exception{
        Context context = new Context(); //是导这个包import org.thymeleaf.context.Context;
        context.setVariable("username","Grey Wolf");
        //获取thymeleaf的html模板 （对应 resources/templates/emailTemplate.html 文件名）
        String emailContent= templateEngine.process("emailTemplate", context);
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        InternetAddress fromAddress = new InternetAddress(MimeUtility.encodeText("Flyat") + "<" + from + ">");// 创建邮件发送者地址
        helper.setFrom(fromAddress);
        InternetAddress toAddress = new InternetAddress(MimeUtility.encodeText("接收方") + "<" + to + ">");// 创建邮件发送者地址
        helper.setTo(toAddress);
        helper.setSubject("Html邮件");
        helper.setText(emailContent, true);//第二个参数指定发送的是HTML格式
        mailSender.send(message);
    }


    // 发送文本邮件
    @Test
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("简单邮件");
        message.setText("简单邮件的简单内容");
        mailSender.send(message);
    }

    // 发送html邮件
    @Test
    public void sendHtmlMail() throws MessagingException {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MimeMessage message = mailSender.createMimeMessage();
        //true表示需要创建一个multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("主题");
        helper.setText(content, true);
        mailSender.send(message);
    }


    // 发送html邮件
    @Test
    public void sendHtmlMessage() throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        InternetAddress fromAddress = new InternetAddress(MimeUtility.encodeText("Flyat") + "<" + from + ">");// 创建邮件发送者地址
        helper.setFrom(fromAddress);
        InternetAddress toAddress = new InternetAddress(MimeUtility.encodeText("接收方") + "<" + to + ">");// 创建邮件发送者地址
        helper.setTo(toAddress);
        helper.setSubject("Html邮件");
        StringBuffer sb = new StringBuffer(); // 发送 content
        sb.append("<h1>大标题-h1</h1>") .append("<p style='color:red;'>红色字</p>");
        //第二个参数指定发送的是HTML格式
        helper.setText(sb.toString(), true);
        mailSender.send(message);
    }


    //发送带附件的邮件
    @Test
    public void sendAttachmentsMail() throws MessagingException, UnsupportedEncodingException {
        MimeMessage message   = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        InternetAddress fromAddress = new InternetAddress(MimeUtility.encodeText("Flyat1111111") + "<" + from + ">");// 创建邮件 发送方地址
        helper.setFrom(fromAddress);
        InternetAddress toAddress = new InternetAddress(MimeUtility.encodeText("接收方22222222") + "<" + to + ">");// 创建邮件 接收方地址
        helper.setTo(toAddress);
        helper.setSubject("带附件的邮件1111");
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>带附件的邮件内容</h1>").append("<p style='color:red;'>红色字</p>");
        //第二个参数指定发送的是HTML格式
        helper.setText(sb.toString(), true);
        //注意项目路径问题，自动补用项目路径
        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/forbidden.jpg"));
        helper.addAttachment("图片.jpg", file);
        mailSender.send(message);
    }

    //发送带附件的邮件
    @Test
    public void sendAttachmentsMail2() throws MessagingException {
        String filePath = "src/main/resources/static/forbidden.jpg";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject("带附件的邮件1111");
        helper.setText("附件内容", true);
        FileSystemResource file = new FileSystemResource(new File(filePath));
        String fileName = filePath.substring(filePath.lastIndexOf(".")); // .jpg
        helper.addAttachment(fileName, file);
        mailSender.send(message);
    }


    //带静态资源的邮件  将资源内联到content内容中   （发送正文中有静态资源（图片）的邮件）
    @Test
    public void sendInlineMail() throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        InternetAddress fromAddress = new InternetAddress(MimeUtility.encodeText("Flya33333") + "<" + from + ">");// 创建邮件发送者地址
        helper.setFrom(fromAddress);
        InternetAddress toAddress = new InternetAddress(MimeUtility.encodeText("接收方232323") + "<" + to + ">");// 创建邮件发送者地址
        helper.setTo(toAddress);
        helper.setSubject("带静态资源的邮件");
        //第二个参数指定发送的是HTML格式
        helper.setText("<html><body>带静态资源的邮件内容 图片:<img src='cid:forbidden' /></body></html>", true);
        FileSystemResource file = new FileSystemResource(new File("src/main/resources/static/forbidden.jpg"));
        helper.addInline("forbidden", file);
        mailSender.send(message);
    }

}
