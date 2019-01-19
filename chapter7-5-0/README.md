#  配置 maven 仓库 路径  
    如果不设置 则maven会默把jar包 下载到 C:\Users\64274\.m2\repository 路径下。。。。
    设置方法： F:\Package\Java Environment\apache-maven-3.3.9\conf 目录下的 settings.xml 文件
    添加  <localRepository>F:\Package\Java Environment\apache-maven-3.3.9\repository</localRepository> 
    
    
#  配置 maven 仓库  阿里云镜像  
    在 <mirror>  </mirrors>   标签中 加入 
        <!-- 阿里云仓库 -->
        <mirror>
            <id>alimaven</id>
            <mirrorOf>central</mirrorOf>
            <name>aliyun maven</name>
            <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
        </mirror>
    
        <!-- 中央仓库1 -->
        <mirror>
            <id>repo1</id>
            <mirrorOf>central</mirrorOf>
            <name>Human Readable Name for this Mirror.</name>
            <url>http://repo1.maven.org/maven2/</url>
        </mirror>
    
        <!-- 中央仓库2 -->
        <mirror>
            <id>repo2</id>
            <mirrorOf>central</mirrorOf>
            <name>Human Readable Name for this Mirror.</name>
            <url>http://repo2.maven.org/maven2/</url>
        </mirror>
        
# war和war exploded的区别 
    （1）war 模式 这种可以称之为是发布模式，看名字也知道，这是先打成war包，再发布；
    （2）war exploded 模式 是直接把文件夹、jsp页面 、classes等等移到Tomcat 部署文件夹里面，进行加载部署。因此这种方式支持热部署，一般在开发的时候也是用这种方式。
    （3）在平时开发的时候，使用热部署的话，应该对Tomcat进行相应的设置，这样的话修改的jsp界面什么的东西才可以及时的显示出来。
    （4）war          模式 发布路径  F:\Package\Java Environment\apache-tomcat-8.0.39\webapps\ROOT\ptms
    （5）war exploded 模式 发布路径  E:\Code\J2EE_code\MySpringBoot\springboot\chapter7-4-1\target\ptms
    
    
# Maven使用之packaging类型
    jar  默认
    pom
    war
    如果是需要部署的项目，则需要打包成war类型 ，如果只是内部调用或者是作服务使用，则推荐打包成jar类型。
