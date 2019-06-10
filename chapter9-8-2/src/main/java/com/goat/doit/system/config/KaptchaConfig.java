package com.goat.doit.system.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;


/**
 * Created by 64274 on 2018/11/7.
 * @author 山羊来了
 * @Description: Kaptcha 验证码 配置文件
 * @date 2018/11/7---22:00
 */
@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){

        Properties properties = new Properties();
        properties.setProperty("kaptcha.border", "yes"); //  图片边框
        properties.setProperty("kaptcha.border.color", "105,179,90"); // 边框颜色
        properties.setProperty("kaptcha.textproducer.font.color", "black");  // 字体颜色
        properties.setProperty("kaptcha.textproducer.char.space", "5"); // 字体间距
        properties.setProperty("kaptcha.image.width", "110"); // 图片宽
        properties.setProperty("kaptcha.image.height", "40");  // 图片高
        properties.setProperty("kaptcha.textproducer.font.size", "30");  // 字体大小
        properties.setProperty("kaptcha.session.key", "code");
        properties.setProperty("kaptcha.textproducer.char.length", "4");  // 验证码长度
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise"); // 噪点生成对象
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑"); // 字体
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(new Config(properties));
        return defaultKaptcha;
    }
}
