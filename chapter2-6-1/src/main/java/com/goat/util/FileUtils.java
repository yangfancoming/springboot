package com.goat.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by 64274 on 2018/12/18.
 *
 * @ Description: 可以看到 test() 和 getPath() 两个同样的方法 获取的路径返回值 不同！
 * @ author  山羊来了
 * @ date 2018/12/18---20:39
 */
public class FileUtils {


    //            String filename = UUID.randomUUID() + suffix;
    //            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));  //文件后缀名

    @Test
    public void test() throws FileNotFoundException {
        // 获取项目发布后的类路径  path=/E:/Code/J2EE_code/MySpringBoot/springboot/chapter2-6-1/target/classes/
        // 获取项目发布后的类路径  path:E:\Code\J2EE_code\MySpringBoot\springboot\chapter2-6-1\target\classes
        mytest();
    }

    //    http://localhost:8261/getPath
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public void getPath() throws FileNotFoundException {
        // 获取项目发布后的类路径 E:/Code/J2EE_code/MySpringBoot/springboot/chapter2-6-1/target/chapter2-6-1-0.0.1-SNAPSHOT/WEB-INF/classes/
        // 获取项目发布后的类路径  E:\Code\J2EE_code\MySpringBoot\springboot\chapter2-6-1\target\chapter2-6-1-0.0.1-SNAPSHOT\WEB-INF\classes
        mytest();
    }

    public void mytest() throws FileNotFoundException {
        String path = getClass().getResource("/").getPath();
        System.out.println("path="+path);
        File file = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!file.exists()) {
            file = new File("");
        }
        System.out.println("path:"+file.getAbsolutePath());
    }
}
