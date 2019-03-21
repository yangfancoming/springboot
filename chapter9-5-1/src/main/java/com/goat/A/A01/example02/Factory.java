package com.goat.A.A01.example02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工厂类，用来创造Api对象
 */
public class Factory {
    /**
     * 具体的创造Api的方法，根据配置文件的参数来创建接口
     * @return 创造好的Api对象
     */
    public static Api createApi() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //直接读取配置文件来获取需要创建实例的类

        //至于如何读取Properties还有如何反射这里就不解释了
        Properties p = new Properties();
        InputStream in = Factory.class.getResourceAsStream("FactoryTest.properties");
//        InputStream in = Factory.class.getResourceAsStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter9-5-1\\src\\main\\java\\com\\goat\\A\\A01\\example02\\FactoryTest.properties");
        p.load(in);
        in.close();

        //用反射去创建，那些例外处理等完善的工作这里就不做了
        Api api = (Api)Class.forName(p.getProperty("ImplClass")).newInstance();
        return api;
    }
}