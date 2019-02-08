# 项目启动后报错：
     Unable to start web server; nested exception is org.springframework.context.ApplicationContextException: 
     Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.
     
     解决方法： 
     在 JacksonApplication  启动类 上 增加注解 @SpringBootApplication 注解来解决问题。
     
# 问题：application.properties中的如下配置不生效，返回时间戳
        原因分析：
           拦截器继承的 WebMvcConfigurationSupport ！
           以前是用 WebMvcConfigurerAdapter ，springboot 2.0 建议使用 WebMvcConfigurationSupport 。
                 但是在添加拦截器并继承 WebMvcConfigurationSupport 后会覆盖@EnableAutoConfiguration关于WebMvcAutoConfiguration的配置！
                 从而导致所有的Date返回都变成时间戳！
        解决方法：  将：extends WebMvcConfigurationSupport  改为： implements WebMvcConfigurer
    
          
   
    
   
           
           
