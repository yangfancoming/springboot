package com.goat;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/28.
 *
 * @ Description: freemarker 文件模板示例
 * @ author  山羊来了
 * @ date 2020/1/28---11:38
 */
public class MyTest01 {


    @Test
    public void test() throws IOException, TemplateException {
        //1.创建FreeMarker的配置类
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //2.指定模板加载器：将模板存入缓存中
        FileTemplateLoader ftl = new FileTemplateLoader(new File("templates"));
        cfg.setTemplateLoader(ftl);
        //3.获取模板
        Template template = cfg.getTemplate("template01.ftl");
        //4.构造数据模型
        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("username","zhangsan");

        //5.文件输出
        /**
         * 处理模型
         *      参数一：数据模型
         *      参数二：writer（FileWriter（文件输出），printWriter（控制台输出））
         */
        //template.process(dataModel,new FileWriter(new File("C:\\Users\\ThinkPad\\Desktop\\ihrm\\day12\\test\\a.txt")));
        template.process(dataModel,new PrintWriter(System.out));
    }
}
