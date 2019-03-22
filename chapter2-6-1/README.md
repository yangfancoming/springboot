
# springboot  集成  JSP 外置Tomcat容器
    第一步：工程的打包方式为war。   <packaging>war</packaging>
    第二步：将spring-boot-starter-tomcat的范围设置为 provided，设置为provided是在打包时会将该包排除，因为要放到独立的tomcat中运行，是不需要的。
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                    <scope>provided</scope>
                </dependency>
    第三步：修改代码，设置启动配置。需要集成 SpringBootServletInitializer，然后重写configure，将Spring Boot的入口类设置进去。
    @SpringBootApplication
    public class BootstrapApplication extends SpringBootServletInitializer {
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(BootstrapApplication.class);
        }

#  文件上传 及 项目根路径/类路径 获取  及 配置文件路径配置



# tomcat的webapp下的root文件夹的作用是什么  Tomcat root 根目录
    tomcat的root文件夹下面默认是tomcat的管理程序，但是如果你把自己的web项目发布到root下面的话，
    你可以不通过项目名直接访问你的项目，比如，你见了一个名为Test的项目，你要访问的路径一般是:http://localhost:8080/Test
    但是你把项目部署在root文件夹下之后，可以通过http://localhost:8080直接访问你的项目
    注意：放在 webapps 目录下的 war包Tomcat是可以自动解压部署的 但是在 root根目录下 必须手动解压后 放在root目录下 才能访问！！！


#  springboot 配置 外置Tomcat  报错：
    Failed to start component [StandardEngine[Catalina].StandardHost[localhost].StandardContext[]]
     解决方法： 查看控制台 报警告 LogBack 和 log4j 两个日志冲突  因为在pom.xml文件中 早就已经解决过 该依赖冲突问题
     把 target 目录删除 重新启动项目后 OK！！！

#  springboot 配置 外置Tomcat  打war 部署到 Tomcat 目录下 报错：
    unable to register MBean
    解决方法：  
    spring.jmx.enabled=false 或
    spring:
      jmx:
        enabled: false