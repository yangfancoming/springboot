# server 端启动后 访问地址： http://localhost:8244/services/user?wsdl

# 错误：

    jaxws 的版本问题
            <dependency>
                <groupId>org.apache.cxf</groupId>
                <artifactId>cxf-rt-frontend-jaxws</artifactId>
                <version>3.2.6</version>
            </dependency>
            
        当 
        parent版本是1.5.6，同时jaxws版本是3.1.6时；
        parent版本是2.0.4，同时jaxws版本是3.2.6时；
        parent版本是2.0.5，同时jaxws版本是3.2.6时；
        parent版本是2.0.6，同时jaxws版本是3.2.6时；
        parent版本是2.1.0，同时jaxws版本是3.2.6时；
        parent版本是2.0.6，同时jaxws版本是3.1.11时；
        会出现以下错误：
        Parameter 1 of constructor in org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration required a bean of type 
        'org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath' that could not be found.
            - Bean method 'dispatcherServletRegistration' not loaded because DispatcherServlet Registration found non dispatcher servlet dispatcherServlet

        当
        parent版本是1.4.5，同时jaxws版本是3.1.7时；
        parent版本是1.4.5，同时jaxws版本是3.1.11时；
        parent版本是1.5.6，同时jaxws版本是3.1.11时；
        parent版本是1.5.8，同时jaxws版本是3.1.12时；
        parent版本是1.5.9，同时jaxws版本是3.1.11时；
        parent版本是1.5.9，同时jaxws版本是3.1.12时；
        parent版本是2.0.3，同时jaxws版本是3.2.6时；  我使用的是这两个版本 
        则运行正常。

        使用 
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web-services</artifactId>
                </dependency>
                
                而不是  <artifactId>spring-boot-starter-webservices</artifactId> 
                
                
                
# 测试  项目启动 
        启动成功后 控制台 打印  ： Creating Service {http://service.server.webservice.demo.goat.com/}AppServiceImplService from class com.goat.webservice.server.service.AppService
        
        
# 报错：
    javax.xml.ws.soap.SOAPFaultException: Unexpected wrapper element {http://service.client.webservice.goat.com/}getUser found.   Expected {http://service.server.webservice.goat.com/}getUser.
    
    原因:是客户端和服务器的namespace不同，即客户端和服务端的WebService接口包路径不一致。
    解决方式：
    1、客户端和服务器的WebService接口包路径相同。
    2、在客户端和服务端的接口注解上指定相同的targetNamespace。建议与包名保持一致。
    3、如果是反向生成的服务器代码，需注释掉:wsdlLocation部分；wsdlLocation会导致找不到具体的服务
    
    总结 server端和client端的  包全类路径名必须相同。。。。。我草！
    
    
    
# 总结 这一套 版本也是可以的
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web-services</artifactId>
                <version>1.4.5.RELEASE</version>
            </dependency>
    
            <dependency>
                <groupId>org.apache.cxf</groupId>
                <artifactId>cxf-rt-frontend-jaxws</artifactId>
                <version>3.1.7</version>
            </dependency>
            <dependency>
                <groupId>org.apache.cxf</groupId>
                <artifactId>cxf-rt-transports-http</artifactId>
                <version>3.1.7</version>
            </dependency>