项目启动后报错：
 Unable to start web server; nested exception is org.springframework.context.ApplicationContextException: 
 Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.
 
 解决方法： 
 在 JacksonApplication  启动类 上 增加注解 @SpringBootApplication 注解来解决问题。
