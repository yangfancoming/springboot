# 引入 自定义工具类  springboot 项目以 可以运行jar 方式启动 项目  总结！！！

# 引入自定义工具类 jar 的项目 打包后运行报错：
    cd 切换到 jar包 目录下 后 执行命令：
    java -jar chapter0-0-7-0.0.1-SNAPSHOT.jar
    
#报错 Error: Unable to access jarfile XXX.jar
    
    解决方法： 使用绝对路径  java -jar E:\Code\J2EE_code\MySpringBoot\springboot\chapter0-0-7\target\chapter0-0-7-0.0.1-SNAPSHOT.jar
    
#又报错：xxxx.jar中没有主清单属性
    以SpringBoot为例，jar包中包含了三个文件夹：BOOT-INF，META-INF，org，可以把jar包解压到文件夹下查看，
    其中META-INF文件夹下有一个MANIFEST.MF文件，该文件指明了程序的入口以及版本信息等内容，如下：
        Manifest-Version: 1.0
        Implementation-Title: spring-xxx-xxx
        Implementation-Version: 0.0.1-SNAPSHOT
        Archiver-Version: Plexus Archiver
        Built-By: XXXX
        Implementation-Vendor-Id: com.huyikang.practice
        Spring-Boot-Version: 1.5.9.RELEASE
        Implementation-Vendor: Pivotal Software, Inc.
        Main-Class: org.springframework.boot.loader.JarLauncher
        Start-Class: com.huyikang.practice.eureka.Application
        Spring-Boot-Classes: BOOT-INF/classes/
        Spring-Boot-Lib: BOOT-INF/lib/
        Created-By: Apache Maven 3.5.2
        Build-Jdk: 1.8.0_151
        Implementation-URL: http://maven.apache.org

    Main-Class代表了Spring Boot中启动jar包的程序
    Start-Class属性就代表了Spring Boot程序的入口类，这个类中应该有一个main方法
    Spring-Boot-Classes代表了类的路径，所有编译后的class文件，以及配置文件，都存储在该路径下
    Spring-Boot-Lib表示依赖的jar包存储的位置
    这些值都是SpringBoot打包插件会默认生成的，如果没有这些属性，SpringBoot程序自然不能运行，就会报错：jar中没有主清单属性，也就是说没有按照SpringBoot的要求，生成这些必须的属性。
    解决办法：  在pom中添加一个SpringBoot的构建的插件，然后重新运行 mvn install即可。

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
    
    
    
# 重新打包运行后 可以看到 springboot 启动 banner 及日志  但是又报错：
     nested exception is java.io.FileNotFoundException: class path resource [com/goat/jar/MyInterface.class] cannot be opened because it does not exist
     
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <includeSystemScope>true</includeSystemScope>
                </configuration>
            </plugin>
            
# 再次 重新编译后  打包部署 访问 http://localhost:8007/test   成功返回信息！ 