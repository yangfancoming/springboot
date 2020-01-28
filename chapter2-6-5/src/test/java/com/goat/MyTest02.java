package com.goat;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/28.
 *
 * @ Description:  freemarker 字符串模板 示例
 * @ author  山羊来了
 * @ date 2020/1/28---17:56
 */
public class MyTest02 {

    @Test
    public void test() throws IOException, TemplateException {
        //1.创建配置对象
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //2.指定加载器
        cfg.setTemplateLoader(new StringTemplateLoader());
        //3.创建字符串模板
        // i.字符串
        String templateString = "欢迎您：${username}";
        // ii.通过字符串创建模板
        Template template = new Template("name1",new StringReader(templateString),cfg);
        //4.构造数据
        Map<String,Object> dataModel = new HashMap<>();
        dataModel.put("username","张三");
        //5.处理模板
        template.process(dataModel,new PrintWriter(System.out));
    }

}
