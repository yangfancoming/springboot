package com.goat.fastjson.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.lang.reflect.Type;

/**
 * Created by 64274 on 2019/3/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/12---16:48
 */
public class JsonUtils {

    public static <T> T readJsonFromClassPath(String path, Type type) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        if (resource.exists()) {
            return JSON.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, type,
                    Feature.AutoCloseSource, // 自动关闭流
                    Feature.AllowComment, // 允许注释
                    Feature.AllowSingleQuotes,// 允许单引号
                    Feature.UseBigDecimal); // 使用 Big decimal
        } else {
            throw new IOException();
        }
    }

//    public static <T> T readJsonFromClassPathList(String path, Type type) throws IOException {
//        ClassPathResource resource = new ClassPathResource(path);
//        if (resource.exists()) {
//            return JSON.parseArray(resource.getInputStream(), StandardCharsets.UTF_8, type,
//                    Feature.AutoCloseSource, // 自动关闭流
//                    Feature.AllowComment, // 允许注释
//                    Feature.AllowSingleQuotes,// 允许单引号
//                    Feature.UseBigDecimal); // 使用 Big decimal
//        } else {
//            throw new IOException();
//        }
//    }
}
