# 配置文件的作用： 修改springboot 自动配置的默认值！

### 全局配置文件：
    Springboot 默认的 两个全局配置文件：application.properties 和 application.yml （文件名是约定死的）
    properties和yml中的配置 相互补充，如果有冲突，则 properties 配置文件的优先级高
    springboot 默认扫描两个配置文件的四个位置(优先级由高到低排列)：

    1. 外置，在相对于应用程序运行目录的/config子目录里
    2. 外置，在应用程序运行的目录里
    3. 内置，在resources/config包内
    4. 内置，在classpath根目录(resouces目录下)  默认是这种

    2、命令行：
    java -jar spring-boot-02-conﬁg-0.0.1-SNAPSHOT.jar –spring.proﬁles.active=dev； 可以直接在测试的时候，配置传入命令行参数
    
    3、虚拟机参数；
    -Dspring.proﬁles.active=dev

# yml 语法： application.yml 规定 
    1. key和value 中 key后的：和value之间必须要有空格
    2. 父子节点的层次关系 通过缩进(使用空格) 表明，做对齐的属性均为同级关系
    3. 属性和值 大小写敏感！


#### @Configuration 和 @Value 使用场景
如果说，我们只是在某个业务逻辑中需要获取一下配置文件中的某项值，使用@Value；
如果说，我们专门编写了一个javaBean来和配置文件进行映射，我们就直接使用@ConfigurationProperties；


#### @ConfigurationProperties @PropertySource   @ImportResource   @Bean
@**ConfigurationProperties**： 只能加载两大默认配置文件 properties  和 yml 
@**PropertySource**：可以加载指定的 properties 配置文件，不能加载yml配置文件
@**ImportResource**：导入Spring的xml配置文件，让配置文件里面的内容生效；
@ImportResource(locations = {"classpath:beans.xml"}) 导入Spring的配置文件让其生效



# 给项目访问路径 增加项目名称 
server.servlet.context-path=/hello
没加的话 项目访问地址  http://localhost:8034
加上之后 项目访问地址 http://localhost:8034/hello



#激活指定profile 四种方式：
	1、在配置文件中指定  spring.profiles.active=dev
	2、命令行：java -jar spring-boot-02-config-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev；
	3、虚拟机参数；-Dspring.profiles.active=dev
	4、@ActiveProfiles("test") // 相当于 配置文件中的 spring.profiles.active=test
		




