
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
        
    第四步： 如果发现 前三步 还不好使， 直接 使用右侧maven clean然后package后  再次启动外置Tomcat  成功！
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
        
# Tomcat Server处理一个HTTP请求的过程

    1、用户点击网页内容，请求被发送到本机端口8080，被在那里监听的Coyote HTTP/1.1 Connector获得。 
    2、Connector把该请求交给它所在的Service的Engine来处理，并等待Engine的回应。 
    3、Engine获得请求localhost/test/index.jsp，匹配所有的虚拟主机Host。 
    4、Engine匹配到名为localhost的Host（即使匹配不到也把请求交给该Host处理，因为该Host被定义为该Engine的默认主机），名为localhost的Host获得请求/test/index.jsp，匹配它所拥有的所有的Context。Host匹配到路径为/test的Context（如果匹配不到就把该请求交给路径名为“ ”的Context去处理）。 
    5、path=“/test”的Context获得请求/index.jsp，在它的mapping table中寻找出对应的Servlet。Context匹配到URL PATTERN为*.jsp的Servlet,对应于JspServlet类。 
    6、构造HttpServletRequest对象和HttpServletResponse对象，作为参数调用JspServlet的doGet（）或doPost（）.执行业务逻辑、数据存储等程序。 
    7、Context把执行完之后的HttpServletResponse对象返回给Host。 
    8、Host把HttpServletResponse对象返回给Engine。 
    9、Engine把HttpServletResponse对象返回Connector。 
    10、Connector把HttpServletResponse对象返回给客户Browser。
        
        
#  外置 Tomcat 部署项目 遇到 本地好使 打war包 部署测试环境好使  但是增量更新到正式环境 出现异常
    1.IDEA 远程调试  发现 xxxclass$1 not found   
    2.是由于 一个java文件中 有2个内部类  导致该java文件编译后 有3个class文件  在增量更新后 只更新了只有1个class 导致出现异常
    
    
#  远程tomcat catalina.sh 配置文件 加入  CATALINA_OPTS=
    #   USE_NOHUP       (Optional) If set to the string true the start command will
    #                   use nohup so that the Tomcat process will ignore any hangup
    #                   signals. Default is "false" unless running on HP-UX in which
    #                   case the default is "true"
    # -----------------------------------------------------------------------------
    CATALINA_OPTS="-Dcom.sun.management.jmxremote
    -Dcom.sun.management.jmxremote.port=1099
    -Dcom.sun.management.jmxremote.ssl=false
    -Dcom.sun.management.jmxremote.authenticate=false
    -Djava.rmi.server.hostname=192.168.136.128
    -agentlib:jdwp=transport=dt_socket,address=5005,suspend=n,server=y"
    export CATALINA_OPTS
    # OS specific support.  $var _must_ be set to either true or false.

#  开启方法
    开启远程Debug服务
    1）对于jar包项目
    命令行添加启动项，如下：
    ## 注意新参数必须在 -jar 之前
    jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -jar test.jar
    
    2）对于war包项目
    启动脚本（catalina.sh）添加如下信息：
    ## sudo vim $CATALINA_HOME/bin/catalina.sh
    JAVA_OPTS="$JAVA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"

    3）开启成功后  远程tomcat catalina.out 日志会显示     Listening for transport dt_socket at address: 5005 
    
# 注意事项
    当开启远程Debug后，任何能走到断点的操作都会导致业务阻塞到断点位置，从而影响业务流程的正常执行，
    所以最好选择没什么用户操作的时候进行远程Debug调试。
    远程Debug调试过程中，结束调试不会导致远程业务流程终止，线上业务会继续执行。
    

