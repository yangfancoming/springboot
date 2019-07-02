本项目 供一下 模块 调用

chapter2-7-1 springboot  集成 HttpClient


#  spring-boot-2.0.4.RELEASE 源码  报错：  折磨死我了 
      Error:java: 服务配置文件不正确, 或构造处理程序对象javax.annotation.processing.Processor: 
      Provider org.springframework.boot.configurationprocessor.ConfigurationMetadataAnnotationProcessor not found时抛出异常错误
      
      是由于  最开始时候 项目启动 会提示 
      Annotation processing seems to be disabled for the project "spring-boot-build". For the plugin to function correctly, 
      please enable it under "Settings > Build > Compiler > Annotation Processors"  点击后 有弹出框
      
      解决： 千万别管这个提示 如果点击了  打钩 弹出框中的  enable annotation processing 选项  那么整个源码项目 运行任何test和项目 
      都会报  服务配置文件不正确, 或构造处理程序对象 的错误！！！
         
