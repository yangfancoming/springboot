# Maven的作用
    1. 方便快捷的管理项目所依赖的jar包
    2. 预定大于配置，统一了开发项目结构
    3. 提供标准的、跨平台的自动化构建方式


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
        
# war 和war exploded 的区别 
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


# 报错 Failed to read artifact descriptor for xxx:jar  
      项目 chapter2-3-2 和 chapter5-3-8 依赖了 chapter0-1-0 但是 chapter2-3-2 package时报错  Failed to read artifact descriptor for xxx:jar 
      是因为 chapter0-1-0 的父项目 springboot 并没有install
      大致翻译一下：如果你有子项目引用了父项目的POM，但没有在父项目POM目录下执行安装操作，这个问题就会出现。
      针对子模块依赖兄弟子模块的情况，需要在父项目POM目录下至少执行一次安装。
      
      
# 报错 
     expected START_TAG or END_TAG not TEXT (position: TEXT seen ...</dependency>-->\n`\n        <d... @56:11).
     expected START_TAG or END_TAG not TEXT (position: TEXT seen ...</dependency>-->\n`\n        <d... @56:11). 
     原因： 依赖是通过复制过来的，存在空格， 
     解决：将日志指示位置的代码code一遍。 去掉 指定位置的空格 或空行
     
# Maven的Snapshot版本与Release版本
    1. Snapshot版本代表不稳定、尚处于开发中的版本
    2. Release版本则代表稳定的版本
    3. 什么情况下该用SNAPSHOT?
    协同开发时，如果A依赖构件B，由于B会更新，B应该使用SNAPSHOT来标识自己。这种做法的必要性可以反证如下：
    a.如果B不用SNAPSHOT，而是每次更新后都使用一个稳定的版本，那版本号就会升得太快，每天一升甚至每个小时一升，这就是对版本号的滥用。
    b.如果B不用SNAPSHOT, 而是一直使用一个单一的Release版本号，那当B更新后，A可能并不会接受到更新。
        因为A所使用的repository一般不会频繁更新release版本的缓存（即本地repository)，
        所以B以不换版本号的方式更新后，A在拿B时发现本地已有这个版本，就不会去远程Repository下载最新的B
    4. 不用Release版本，在所有地方都用SNAPSHOT版本行不行？
        不行。正式环境中不得使用snapshot版本的库。 
        比如说，今天你依赖某个snapshot版本的第三方库成功构建了自己的应用，明天再构建时可能就会失败，
        因为今晚第三方可能已经更新了它的snapshot库。
        你再次构建时，Maven会去远程repository下载snapshot的最新版本，
        你构建时用的库就是新的jar文件了，这时正确性就很难保证了。


# 理解maven命令package、install、deploy的联系与区别
    仔细查看上面的输出结果截图，可以发现，
    mvn clean package依次执行了clean、resources、compile、testResources、testCompile、test、jar(打包)等７个阶段。
    mvn clean install依次执行了clean、resources、compile、testResources、testCompile、test、jar(打包)、install等8个阶段。
    mvn clean deploy依次执行了clean、resources、compile、testResources、testCompile、test、jar(打包)、install、deploy等９个阶段。
    
    由上面的分析可知主要区别如下，
    package命令完成了项目编译、单元测试、打包功能，但没有把打好的可执行jar包（war包或其它形式的包）布署到本地maven仓库和远程maven私服仓库
    install命令完成了项目编译、单元测试、打包功能，同时把打好的可执行jar包（war包或其它形式的包）布署到本地maven仓库，但没有布署到远程maven私服仓库
    deploy命令完成了项目编译、单元测试、打包功能，同时把打好的可执行jar包（war包或其它形式的包）布署到本地maven仓库和远程maven私服仓库
