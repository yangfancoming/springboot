    1）、所有 /webjars/** ，都去 classpath:/META-INF/resources/webjars/ 找资源；
    2）、"/**" 访问当前项目的任何资源，都去（静态资源的文件夹）找映射
    
    "classpath:/META-INF/resources/",   
    "classpath:/resources/"             测试url：http://localhost:8202/favicon.ico  可以访问
    "classpath:/static/",               测试url：http://localhost:8202/asserts/img/bootstrap-solid.svg
    "classpath:/public/"                测试url：http://localhost:8202/ 默认访问  index.html 同 http://localhost:8202/index.html
                                        测试url：http://localhost:8202/hello.html  可以访问 hello.html
    "/"：当前项目的根路径
    
    
# springboot 内置配置
    官方推荐直接实现WebMvcConfigurer或者直接继承WebMvcConfigurationSupport，
    方式一实现 WebMvcConfigurer 接口（推荐），
    方式二继承 WebMvcConfigurationSupport 类