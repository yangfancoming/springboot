# 引入依赖
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>easyexcel</artifactId>
                <version>1.1.2-beat1</version>
            </dependency>
            
            
# git  提交报错：  
    0 files committed, 1 file failed to commit: 
    增加 springboot 集成 Alibaba easyExcel 增加 Write03 写入 03版Excel On branch master Your branch is ahead of 'origin/master' by 1 commit.
     (use "git push" to publish your local commits) Untracked files: a.ini chapter3-5-0/src/main/java/com/goat/utils/LicenseGenerator.java
      chapter5-1-4/src/main/java/com/goat/utils/ chapter7-5-5/src/123.xlsx 
      chapter8-4-2/src/222.png chapter8-4-2/src/333.png 
      chapter8-4-2/src/main/java/com/goat/utils/QRCodeUtil.java 
      chapter99-8-3/a.ini license.lic nothing added to commit but untracked 
      
      网上看到的解决方式：
      1.遇到这种问题，表示在你之前已经有x个commit了，直接git reset --hard HEAD~x解决 ,这里的x表示的就是在这之前已经有多少次的提交，这句命令的意思就是直接回退到x 个commit之前。这样就可以了。
      2. git push origin  或者  git reset --hard origin/master
       
        但是我的解决方式是： 把IDEA 关闭 然后重启  就好了。。。 我草！
         
 #  easypoi 与阿里的 easyExcel 对比
    区别就是两者的解析不同
    easypoi的解析方式是dom解析,把结果一次都读入内存操作,这样的操作平时是不会有问题的,但是并发量上来的时候就会出现OOM
    阿里的 easyExcel 运用的SAX的解析方式,明显降低了内存,但是速率下降