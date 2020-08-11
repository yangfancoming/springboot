    1）、所有 /webjars/** ，都去 classpath:/META-INF/resources/webjars/ 找资源；
    2）、"/**" 访问当前项目的任何资源，都去（静态资源的文件夹）找映射
    
    "classpath:/META-INF/resources/",   
    "classpath:/resources/"             测试url：http://localhost:8202/favicon.ico  可以访问
    "classpath:/static/",               测试url：http://localhost:8202/asserts/img/bootstrap-solid.svg
    "classpath:/public/"                测试url：http://localhost:8202/ 默认访问  index.html 同 http://localhost:8202/index.html
                                        测试url：http://localhost:8202/hello.html  可以访问 hello.html
    "/"：当前项目的根路径
    
    
# springboot 内置配置
    官方推荐直接实现 WebMvcConfigurer 或者直接继承 WebMvcConfigurationSupport，
    方式一实现 WebMvcConfigurer 接口（推荐），
    方式二继承 WebMvcConfigurationSupport 类
    
    
    
# springboot打出的jar   替换其中的class或是 子jar  报错问题
    报错：
    Caused by: java.lang.IllegalStateException: Unable to open nested entry 'BOOT-INF/lib/**.jar'. 
    It has been compressed and nested jar files must be stored without compression. (嵌套的jar必须直接存储, 而不能压缩)
    Please check the mechanism used to create your executable jar file
    
    解决方法1: jar命令解压, 替换后进行压缩(参考: https://www.cnblogs.com/zhjh256/p/10986920.html)
    jar -xvf ./*.jar
    jar -cfM0 *.jar ./
    
    
    解决方法2: winrar或7zip添加文件的时候,选择要添加的jar或class后，
     再将选择压缩方式由"标准"改为存储(Store) (参考: https://www.jianshu.com/p/9df4a0bb46be)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    