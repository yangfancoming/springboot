#  是由于有替换了  catalina.sh 文件后  启动tomcat 报错 文件找不到 
    
    [root@localhost bin]# ./startup.sh
    Cannot find ./catalina.sh
    The file is absent or does not have execute permission
      This file is needed to run this program
      [root@localhost bin]# chmod 777 /home/glb-tomcat/bin/catalina.sh
      [root@localhost bin]# ./startup.sh
      Using CATALINA_BASE:   /home/glb-tomcat
      Using CATALINA_HOME:   /home/glb-tomcat
      Using CATALINA_TMPDIR: /home/glb-tomcat/temp
      Using JRE_HOME:        /usr
      Using CLASSPATH:       /home/glb-tomcat/bin/bootstrap.jar:/home/glb-tomcat/bin/tomcat-juli.jar
      Tomcat started.
 
     解决方法：
         可以看到文件的属性 变为 rwx-r--r-- 和bin目录中的其他文件属性  rwxrwxrwx 明显不一样
         所以考虑到 更改 替换后的 catalina.sh  文件的权限
         命令  chmod 777 /home/glb-tomcat/bin/catalina.sh  后 解决问题！
    