package com.goat.tiny.test.stream;

import org.junit.Test;

import java.io.InputStream;

/**
 * Created by 64274 on 2019/7/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/23---13:08
 */
public class MyTest {

    public static void main(String[] args) {


    }

    @Test
    public void test(){

        // 相对路径 不以’/'开头时默认是从此类所在的包下取资源
        InputStream a = MyTest.class.getResourceAsStream("a.properties") ;

        // 绝对路径以'/'开头
        InputStream c = MyTest.class.getResourceAsStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-3-0\\src\\main\\java\\com\\goat\\tiny\\mybatis\\file\\c.properties") ;

        InputStream d = MyTest.class.getResourceAsStream("/com/goat/tiny/test/file/c.properties") ;

        // ClassLoader的getResourceAsStream(String path)  默认则是从ClassPath根下获取，path不能以'/'开头
        InputStream e1 = MyTest.class.getClassLoader().getResourceAsStream("b.properties") ;
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream e2 = classLoader.getResourceAsStream("b.properties") ;

        // doit  为啥只有 e1 和 e2 好使？？？
        System.out.println(a);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(c);
        System.out.println(d);
    }


}
