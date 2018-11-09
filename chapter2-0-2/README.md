1）、所有 /webjars/** ，都去 classpath:/META-INF/resources/webjars/ 找资源；

2）、"/**" 访问当前项目的任何资源，都去（静态资源的文件夹）找映射

"classpath:/META-INF/resources/", 
"classpath:/resources/",
"classpath:/static/", 
"classpath:/public/" 
"/"：当前项目的根路径