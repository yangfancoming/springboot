package com.goat.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Created by 64274 on 2018/6/2.
 *
 * sos util类  因为 从配置文件中读取数据 所以 在其他类中 引用的时候 必须要
 *   @Autowired private FreemarkerUtils freemarkerUtils; 后 使用， 不能new出来使用！ 否则  @Value 取不到值 为null
 */
@Component
public class FreemarkerUtils {

    @Value("${spring.freemarker.charset}")       public  String charset;
    @Value("${spring.freemarker.template_path}") public  String template_path;
    @Value("${spring.freemarker.out_path}")      public  String out_path;

    public  void common(Map map,String file_name,String out_filename) throws Exception {
        //创建一个freemarker.template.Configuration 实例，它是存储 FreeMarker 应用级设置的核心部分
        Configuration cfg = new Configuration(Configuration.getVersion());
        cfg.setDirectoryForTemplateLoading(new File(template_path));// 设置模板所在路径
        cfg.setDefaultEncoding(charset); //设置默认编码格式
        Template temp = cfg.getTemplate(file_name); //从设置的目录中获得模板
        Writer out = new FileWriter(new File(out_path + out_filename));    //合并模板和数据模型
        temp.process(map, out);
        out.flush();out.close();//关闭
    }

}
