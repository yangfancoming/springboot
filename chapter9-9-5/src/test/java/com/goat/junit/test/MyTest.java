package com.goat.junit.test;

import org.junit.Test;

import java.net.URL;

/**
 * Created by 64274 on 2019/7/26.
 *
 * @ Description: 测试结果 可以读取到 resources 目录下的配置文件  3-0-8 项目之所以读取不到是因为  pom.xml 依赖中他没有父项目
 * @ author  山羊来了
 * @ date 2019/7/26---17:34
 */
public class MyTest {

    @Test
    public void test(){
        URL resource = this.getClass().getClassLoader().getResource("tiny.xml");
        // file:/E:/Code/J2EE_code/MySpringBoot/springboot/chapter9-9-5/target/test-classes/tiny.xml
        System.out.println(resource);
    }
}
