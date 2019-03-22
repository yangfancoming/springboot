#  项目启动后报错：
    Because it is not available in either (1) JVM system property 'env'
     解决方法： 启动项目时修改配置
    -Denv=DEV
    -Denv就是开发环境 DEV表示阿波罗里面的集群名称
    linux服务器启动jar 也需要加一个这个，例如 java -Denv=DEV -jar abc.jar
    
#  项目启动后报错：
    Load config failed, will retry in 1 SECONDS. appId: SampleApp, 