package com.goat;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
     * @Description: 功能描述： freemarker 文件生成
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:  2018年11月30日14:13:03
*/
public class TestNg {

    @Test
    public void test() throws IOException, TemplateException {
        // 设置模板文件的目录
        String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-6-5\\src\\test\\java\\com\\goat";
        Configuration conf = new Configuration(Configuration.getVersion());
        conf.setDirectoryForTemplateLoading(new File(path));
        conf.setDefaultEncoding("UTF-8");
        // 指定 freemarker 的ftl模板文件
        Template template = conf.getTemplate("hello.ftl");
        Map map = new HashMap();
        map.put("hello","wagagaga"); // 写入数据
        Writer out = new FileWriter(new File(path+"\\myOut.txt"));// 指定生成目录和文件名
        template.process(map,out);
        out.close();
    }

}
