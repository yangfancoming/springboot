package com.goat.webservice.demo.service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Component;


@Component
public class Cxfclient {

    //webservice接口地址
    private static String address = "http://localhost:1126/WebService.asmx?WSDL";

    private JaxWsDynamicClientFactory dcf ;
    private JaxWsProxyFactoryBean jpf ;
    private  Client client;

    private Cxfclient() {
        this.dcf = JaxWsDynamicClientFactory.newInstance();
        this.client = dcf.createClient(address);
        this.jpf = new JaxWsProxyFactoryBean(); // 代理工厂
        this.jpf.setAddress(address);   // 设置代理地址
        this.jpf.getOutInterceptors().add(new LoginInterceptor("root","admin"));  //添加用户名密码拦截器
        this.jpf.setServiceClass(AppService.class); // 设置接口类型
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public JaxWsProxyFactoryBean getJpf() {
        return jpf;
    }

    public void setJpf(JaxWsProxyFactoryBean jpf) {
        this.jpf = jpf;
    }

    public JaxWsDynamicClientFactory getDcf() {
        return dcf;
    }

    public void setDcf(JaxWsDynamicClientFactory dcf) {
        this.dcf = dcf;
    }



    //webservice接口地址
    private static String address1 = "http://localhost:8244/services/user?wsdl";

    //测试
    public static void main(String[] args) {
//                test1();
        test2();
    }

    /**
     * 方式1:使用代理类工厂,需要拿到对方的接口
     * sos 该种方式调用  必须保证 server端和client端的  包全类路径名必须相同。。。。。我草！
     * 即： server 端 com.goat.webservice.demo.service
     * 那么 client 端 也必须是 com.goat.webservice.demo.service
     */
    public static void test1() {
        try {
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean(); // 代理工厂
            jaxWsProxyFactoryBean.setAddress(address1);   // 设置代理地址
            jaxWsProxyFactoryBean.getOutInterceptors().add(new LoginInterceptor("root","admin"));  //添加用户名密码拦截器
            jaxWsProxyFactoryBean.setServiceClass(AppService.class); // 设置接口类型
            AppService cs = (AppService) jaxWsProxyFactoryBean.create();  // 创建一个代理接口实现
            String LineId = "1";  // 数据准备
            String result = cs.getUser(LineId);  // 调用代理接口的方法调用并返回结果  {http://service.client.webservice.goat.com/}getUser found.
            System.out.println("==============返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  方式2:动态调用方式
     *  sos 该种方式调用 必须保证 server 端的 @WebService(targetNamespace ="http://service.demo.webservice.goat.com/") 中的 targetNamespace
     *   和  client 端 createElementNS("service.demo.webservice.goat.com/","SecurityHeader"); 中的  service.demo.webservice.goat.com/
     *   是对应的！
     */
    public static void test2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(address1);
        // 需要密码的情况需要加上用户名和密码 服务端会校检用户名和密码  如果校检失败 则不予提供服务。
        client.getOutInterceptors().add(new LoginInterceptor("root","admin"));
        Object[] objects;
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            System.out.println("======client"+client);
            objects = client.invoke("test", "1",1,"GOAT",true);
            System.out.println("返回数据:" + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}