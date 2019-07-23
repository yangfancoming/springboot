package com.goat.tiny.mybatis.stream;

import java.io.InputStream;

/**
 * Created by 64274 on 2019/7/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/23---13:08
 */
public class Test {

    public static void main(String[] args) {

        // 相对路径 不以’/'开头时默认是从此类所在的包下取资源
        InputStream a = Test.class.getResourceAsStream("a.properties") ;
        // ClassLoader的getResourceAsStream(String path)  默认则是从ClassPath根下获取，path不能以'/'开头
        InputStream b = Test.class.getClassLoader().getResourceAsStream("b.properties") ;

        // 绝对路径以'/'开头
        InputStream c = Test.class.getResourceAsStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-0\\src\\main\\java\\com\\goat\\tiny\\mybatis\\file\\c.properties") ;

        InputStream d = Test.class.getResourceAsStream("/com/goat/tiny/mybatis/file/c.properties") ;

        // doit  为啥只有 b 好使？？？
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
