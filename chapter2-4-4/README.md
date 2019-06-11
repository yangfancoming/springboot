# 错误：

    jaxws 的版本问题
            <dependency>
                <groupId>org.apache.cxf</groupId>
                <artifactId>cxf-rt-frontend-jaxws</artifactId>
                <version>3.2.6</version>
            </dependency>
            
        当 
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